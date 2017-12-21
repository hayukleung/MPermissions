package com.hayukleung.mpermissions

import android.support.v7.app.AppCompatActivity

/**
 * MPermissions
 *
 * liangxiaxu@aobi.com
 * 2017-12-21 15:45
 */
open class MPsActivity : AppCompatActivity() {

    private val mRequestPermissionsDelegateList : MutableList<RequestPermissionsDelegate> = ArrayList()

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        for (requestPermissionsDelegate in mRequestPermissionsDelegateList) {
            requestPermissionsDelegate.onRequestPermissionsResult(requestCode, permissions, grantResults)
        }
        mRequestPermissionsDelegateList.clear()
    }

    fun addRequestPermissionsDelegate(requestPermissionsDelegate: RequestPermissionsDelegate) {
        mRequestPermissionsDelegateList.add(requestPermissionsDelegate)
    }
}