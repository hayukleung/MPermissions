package com.hayukleung.mpermissions

import android.os.Bundle
import android.widget.Toast
import com.hayukleung.mpermissions.impl.CameraPermissionHelper
import com.hayukleung.mpermissions.impl.PhonePermissionHelper
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
                    toast("拒绝存储", Toast.LENGTH_SHORT)
                }

                override fun onPermissionGranted() {
                    toast("同意存储", Toast.LENGTH_SHORT)
                }
            })
        }

        if (!PhonePermissionHelper.checkPermission(this)) {
            PhonePermissionHelper.requestPermissionIfNeed(this, object : Helper.Listener {
                override fun onPermissionDenied() {
                    toast("拒绝 Phone", Toast.LENGTH_SHORT)
                }

                override fun onPermissionGranted() {
                    toast("同意 Phone", Toast.LENGTH_SHORT)
                }
            })
        }

        if (!CameraPermissionHelper.checkPermission(this)) {
            CameraPermissionHelper.requestPermissionIfNeed(this, object : Helper.Listener {
                override fun onPermissionDenied() {
                    toast("拒绝相机", Toast.LENGTH_SHORT)
                }

                override fun onPermissionGranted() {
                    toast("同意相机", Toast.LENGTH_SHORT)
                }
            })
        }
    }
}