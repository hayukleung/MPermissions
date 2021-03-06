package com.hayukleung.mpermissions

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.net.Uri
import android.os.Looper
import android.support.annotation.StringRes
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AlertDialog


/**
 * MPermissions
 *
 * liangxiaxu@aobi.com
 * 2017-12-21 16:12
 */
abstract class Helper {

    interface Listener {
        fun onPermissionDenied()
        fun onPermissionGranted()
    }

    fun requestPermissionIfNeed(activity: MPsActivity, packageName: String, listener: Listener) {
        requestPermissionIfNeed(activity, packageName, listener, true)
    }

    fun requestPermissionIfNeed(activity: MPsActivity, packageName: String, listener: Listener, showMustGrantDialog: Boolean) {
        if (!checkSelfPermission(activity)) {
            requestPermission(activity, packageName, listener, showMustGrantDialog)
        } else {
            listener.onPermissionGranted()
        }
    }

    fun checkSelfPermission(context: Context): Boolean {
        val result = ActivityCompat.checkSelfPermission(context, permission())
        return PackageManager.PERMISSION_GRANTED == result
    }

    private fun requestPermission(activity: MPsActivity, packageName: String, listener: Listener, showMustGrantDialog: Boolean) {
        activity.addRequestPermissionsDelegate(requestCode(), object : RequestPermissionsDelegate {
            override fun onRequestPermissionsResult(permissions: Array<out String>, grantResults: IntArray) {
                if (grantResults.isEmpty() || PackageManager.PERMISSION_GRANTED != grantResults[0]) {
                    if (!shouldShowRequestPermissionRationale(activity)) {
                        // 说明用户勾选了不再提示
                        if (showMustGrantDialog) {
                            showMustGrantDialog(activity, packageName, listener)
                        } else {
                            listener.onPermissionDenied()
                        }
                    } else {
                        // 首次拒绝或未勾选不再提示的拒绝
                        listener.onPermissionDenied()
                    }
                } else {
                    listener.onPermissionGranted()
                }
            }
        })

        ActivityCompat.requestPermissions(activity, arrayOf(permission()), requestCode())
    }

    private fun shouldShowRequestPermissionRationale(activity: Activity): Boolean {
        return ActivityCompat.shouldShowRequestPermissionRationale(activity, permission())
    }

    private fun showMustGrantDialog(activity: MPsActivity, packageName: String, listener: Listener) {

        if (Looper.myLooper() != Looper.getMainLooper()) {
            return
        }

        val builder: AlertDialog.Builder = AlertDialog.Builder(activity)
        builder.setTitle("APP 获取权限失败")
        builder.setMessage(permissionRequiredHint())
        builder.setNegativeButton("残忍拒绝") { dialog, which ->
            listener.onPermissionDenied()
            dialog.dismiss()
        }
        builder.setPositiveButton("欣然同意") { dialog, which ->
            goSettings(activity, packageName)
            dialog.dismiss()
        }

        val dialog: AlertDialog = builder.create()
        dialog.show()
        // https://blog.csdn.net/sj617913246/article/details/73692998
        dialog.getButton(DialogInterface.BUTTON_POSITIVE).setTextColor(Color.BLUE)
        dialog.getButton(DialogInterface.BUTTON_NEGATIVE).setTextColor(Color.BLUE)
    }

    /**
     * 跳转系统设置
     */
    private fun goSettings(activity: MPsActivity, packageName: String) {
        val localIntent = Intent()
        // localIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        localIntent.action = "android.settings.APPLICATION_DETAILS_SETTINGS"
        localIntent.data = Uri.fromParts("package", packageName, null)
        activity.startActivityForResult(localIntent, REQUEST_CODE_SETTING)
    }

    /**
     * @see Manifest.permission.READ_CALENDAR
     * @see Manifest.permission.WRITE_CALENDAR
     *
     * @see Manifest.permission.CAMERA
     *
     * @see Manifest.permission.READ_CONTACTS
     * @see Manifest.permission.WRITE_CONTACTS
     * @see Manifest.permission.GET_ACCOUNTS
     *
     * @see Manifest.permission.ACCESS_FINE_LOCATION
     * @see Manifest.permission.ACCESS_COARSE_LOCATION
     *
     * @see Manifest.permission.RECORD_AUDIO
     *
     * @see Manifest.permission.READ_PHONE_STATE
     * @see Manifest.permission.CALL_PHONE
     * @see Manifest.permission.READ_CALL_LOG
     * @see Manifest.permission.WRITE_CALL_LOG
     * @see Manifest.permission.ADD_VOICEMAIL
     * @see Manifest.permission.USE_SIP
     * @see Manifest.permission.PROCESS_OUTGOING_CALLS
     *
     * @see Manifest.permission.BODY_SENSORS
     *
     * @see Manifest.permission.SEND_SMS
     * @see Manifest.permission.RECEIVE_SMS
     * @see Manifest.permission.READ_SMS
     * @see Manifest.permission.RECEIVE_WAP_PUSH
     * @see Manifest.permission.RECEIVE_MMS
     *
     * @see Manifest.permission.WRITE_EXTERNAL_STORAGE
     * @see Manifest.permission.READ_EXTERNAL_STORAGE
     */
    protected abstract fun permission(): String

    /**
     * @see PERMISSION_REQUEST_CODE_CALENDAR
     * @see PERMISSION_REQUEST_CODE_CAMERA
     * @see PERMISSION_REQUEST_CODE_CONTACTS
     * @see PERMISSION_REQUEST_CODE_LOCATION
     * @see PERMISSION_REQUEST_CODE_MICROPHONE
     * @see PERMISSION_REQUEST_CODE_PHONE
     * @see PERMISSION_REQUEST_CODE_SENSORS
     * @see PERMISSION_REQUEST_CODE_SMS
     * @see PERMISSION_REQUEST_CODE_STORAGE
     */
    protected abstract fun requestCode(): Int

    @StringRes
    protected abstract fun permissionRequiredHint(): Int
}