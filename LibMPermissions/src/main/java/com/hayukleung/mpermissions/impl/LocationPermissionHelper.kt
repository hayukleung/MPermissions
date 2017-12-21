package com.hayukleung.mpermissions.impl

import android.Manifest
import com.hayukleung.mpermissions.Helper
import com.hayukleung.mpermissions.PERMISSION_REQUEST_CODE_LOCATION

/**
 * MPermissions
 *
 * liangxiaxu@aobi.com
 * 2017-12-21 17:54
 */
object LocationPermissionHelper : Helper() {

    override fun permission(): String {
        return Manifest.permission.ACCESS_FINE_LOCATION
        // or return Manifest.permission.ACCESS_COARSE_LOCATION
    }

    override fun requestCode(): Int {
        return PERMISSION_REQUEST_CODE_LOCATION
    }
}