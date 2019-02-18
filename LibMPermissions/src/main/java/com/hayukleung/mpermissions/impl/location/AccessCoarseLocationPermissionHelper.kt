package com.hayukleung.mpermissions.impl.location

import android.Manifest
import com.hayukleung.mpermissions.Helper
import com.hayukleung.mpermissions.PERMISSION_REQUEST_CODE_ACCESS_COARSE_LOCATION
import com.hayukleung.mpermissions.R

/**
 * MPermissions
 *
 * liangxiaxu@aobi.com
 * 2017-12-21 17:54
 */
class AccessCoarseLocationPermissionHelper : Helper() {

    override fun permission(): String {
        return Manifest.permission.ACCESS_COARSE_LOCATION
    }

    override fun requestCode(): Int {
        return PERMISSION_REQUEST_CODE_ACCESS_COARSE_LOCATION
    }

    override fun permissionRequiredHint(): Int {
        return R.string.permission_required_location
    }
}