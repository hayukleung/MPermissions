package com.hayukleung.mpermissions

import android.os.Bundle
import android.widget.Toast
import com.hayukleung.mpermissions.impl.StoragePermissionHelper

/**
 * MPermissions
 *
 * liangxiaxu@aobi.com
 * 2017-12-21 16:53
 */
open class RequestPermissionActivity : MPsActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!StoragePermissionHelper.checkPermission(this)) {
            StoragePermissionHelper.requestPermissionIfNeed(this, object : Helper.Listener {
                override fun onPermissionDenied() {
                    toast("拒绝", Toast.LENGTH_SHORT)
                }

                override fun onResult(grantResults: IntArray) {
                    if (!grantResults.isEmpty() && 0 == grantResults[0]) {
                        toast("同意", Toast.LENGTH_SHORT)
                    }
                }
            })
        }
    }
}