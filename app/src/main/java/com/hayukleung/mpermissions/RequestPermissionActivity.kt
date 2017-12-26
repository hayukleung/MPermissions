package com.hayukleung.mpermissions

import android.os.Bundle
import com.hayukleung.mpermissions.impl.StoragePermissionHelper

/**
 * MPermissions
 *
 * liangxiaxu@aobi.com
 * 2017-12-21 16:53
 */
class RequestPermissionActivity : MPsActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        checkPermissions()
    }

    override fun onSettingReturn() {
        checkPermissions()
    }

    private fun checkPermissions() {
        StoragePermissionHelper.requestPermissionIfNeed(this, packageName, object : Helper.Listener {
            override fun onPermissionDenied() {
                toast("拒绝存储")
            }

            override fun onPermissionGranted() {
                toast("同意存储")
            }
        })
    }
}