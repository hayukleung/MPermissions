package com.hayukleung.mpermissions

import android.content.Intent
import android.support.v7.app.AppCompatActivity

/**
 * MPermissions
 *
 * liangxiaxu@aobi.com
 * 2017-12-21 15:45
 */
abstract class MPsActivity : AppCompatActivity() {

    private val mRequestPermissionsDelegateMap: MutableMap<Int, RequestPermissionsDelegate> = HashMap()

    fun addRequestPermissionsDelegate(requestCode: Int, requestPermissionsDelegate: RequestPermissionsDelegate) {
        if (mRequestPermissionsDelegateMap.containsKey(requestCode)) {
            mRequestPermissionsDelegateMap.remove(requestCode)
        }
        mRequestPermissionsDelegateMap[requestCode] = requestPermissionsDelegate
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        val requestPermissionsDelegate: RequestPermissionsDelegate? = mRequestPermissionsDelegateMap[requestCode]
        requestPermissionsDelegate?.onRequestPermissionsResult(permissions, grantResults)
        mRequestPermissionsDelegateMap.remove(requestCode)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            REQUEST_CODE_SETTING -> {
                onSettingReturn()
            }
        }
    }

    /**
     * 从设置页返回
     */
    abstract fun onSettingReturn()
}