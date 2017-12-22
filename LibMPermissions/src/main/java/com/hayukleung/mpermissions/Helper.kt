package com.hayukleung.mpermissions

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
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

    private fun checkSelfPermission(context: Context): Boolean {
        val result = ActivityCompat.checkSelfPermission(context, permission())
        return PackageManager.PERMISSION_GRANTED == result
    }

    private fun requestPermission(activity: MPsActivity, packageName: String, listener: Listener) {
        activity.addRequestPermissionsDelegate(requestCode(), object : RequestPermissionsDelegate {
            override fun onRequestPermissionsResult(permissions: Array<out String>, grantResults: IntArray) {
                if (grantResults.isEmpty() || PackageManager.PERMISSION_GRANTED != grantResults[0]) {
                    listener.onPermissionDenied()
                    if (!shouldShowRequestPermissionRationale(activity)) {
                        // 说明用户勾选了不再提示
                        // FIXME showMustGrantDialog(activity, packageName)
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

    private fun goSettings(activity: MPsActivity, packageName: String) {
        val localIntent = Intent()
        localIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        localIntent.action = "android.settings.APPLICATION_DETAILS_SETTINGS"
        localIntent.data = Uri.fromParts("package", packageName, null)
        activity.startActivity(localIntent)
    }

    private fun showMustGrantDialog(activity: MPsActivity, packageName: String) {

        val builder: AlertDialog.Builder = AlertDialog.Builder(activity)
        builder.setTitle("APP 怒了")
        builder.setMessage(permissionRequiredHint())
        builder.setNegativeButton("残忍拒绝") { dialog, which ->
            dialog.dismiss()
        }
        builder.setPositiveButton("欣然同意") { dialog, which ->
            goSettings(activity, packageName)
            dialog.dismiss()
        }
        builder.create().show()
    }

    fun requestPermissionIfNeed(activity: MPsActivity, packageName: String, listener: Listener) {
        if (!checkSelfPermission(activity)) {
            requestPermission(activity, packageName, listener)
        } else {
            listener.onPermissionGranted()
        }
    }

    protected abstract fun permission(): String

    protected abstract fun requestCode(): Int

    @StringRes
    protected abstract fun permissionRequiredHint(): Int
}