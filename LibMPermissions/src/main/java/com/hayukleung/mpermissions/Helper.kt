package com.hayukleung.mpermissions

import android.content.Context
import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat

/**
 * MPermissions
 *
 * liangxiaxu@aobi.com
 * 2017-12-21 16:12
 */
abstract class Helper {

    interface Listener {
        fun onPermissionDenied()
        fun onResult(grantResults: IntArray)
    }

    fun checkPermission(context: Context): Boolean {
        val result = ActivityCompat.checkSelfPermission(context, permission())
        return PackageManager.PERMISSION_GRANTED == result
    }

    fun requestPermissionIfNeed(activity: MPsActivity, listener: Listener) {
        if (!checkPermission(activity)) {

            activity.addRequestPermissionsDelegate(object : RequestPermissionsDelegate {
                override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
                    if (grantResults.isEmpty() || PackageManager.PERMISSION_GRANTED != grantResults[0]) {
                        listener.onPermissionDenied()
                    }
                    listener.onResult(grantResults)
                }
            })

            ActivityCompat.requestPermissions(activity, arrayOf(permission()), requestCode())
        }
    }

    protected abstract fun permission(): String

    protected abstract fun requestCode(): Int
}