package com.hayukleung.mpermissions.impl

import android.Manifest
import com.hayukleung.mpermissions.Helper
import com.hayukleung.mpermissions.PERMISSION_REQUEST_CODE_STORAGE

/**
 * MPermissions
 *
 * liangxiaxu@aobi.com
 * 2017-12-21 16:49
 */
object StoragePermissionHelper : Helper() {

    override fun permission(): String {
        return Manifest.permission.WRITE_EXTERNAL_STORAGE
    }

    override fun requestCode(): Int {
        return PERMISSION_REQUEST_CODE_STORAGE
    }
}