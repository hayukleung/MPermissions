package com.hayukleung.mpermissions

import android.support.v7.app.AppCompatActivity

/**
 * MPermissions
 *
 * liangxiaxu@aobi.com
 * 2017-12-21 15:45
 */
open class MPsActivity : AppCompatActivity() {

    private val mRequestPermissionsDelegateMap : MutableMap<Int, RequestPermissionsDelegate> = HashMap()

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        val requestPermissionsDelegate : RequestPermissionsDelegate ?= mRequestPermissionsDelegateMap[requestCode]
        requestPermissionsDelegate?.onRequestPermissionsResult(permissions, grantResults)
        mRequestPermissionsDelegateMap.remove(requestCode)
    }

    fun addRequestPermissionsDelegate(requestCode: Int, requestPermissionsDelegate: RequestPermissionsDelegate) {
        mRequestPermissionsDelegateMap.put(requestCode, requestPermissionsDelegate)
    }
}