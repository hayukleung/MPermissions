package com.hayukleung.mpermissions.impl.camera

import android.Manifest
import com.hayukleung.mpermissions.Helper
import com.hayukleung.mpermissions.PERMISSION_REQUEST_CODE_CAMERA
import com.hayukleung.mpermissions.R

/**
 * MPermissions
 *
 * liangxiaxu@aobi.com
 * 2017-12-21 17:54
 */
class CameraPermissionHelper : Helper() {

    override fun permission(): String {
        return Manifest.permission.CAMERA
    }

    override fun requestCode(): Int {
        return PERMISSION_REQUEST_CODE_CAMERA
    }

    override fun permissionRequiredHint(): Int {
        return R.string.permission_required_camera
    }
}