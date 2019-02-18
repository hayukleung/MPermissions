package com.hayukleung.mpermissions.impl.storage

import android.Manifest
import com.hayukleung.mpermissions.Helper
import com.hayukleung.mpermissions.PERMISSION_REQUEST_CODE_WRITE_EXTERNAL_STORAGE
import com.hayukleung.mpermissions.R

/**
 * MPermissions
 *
 * liangxiaxu@aobi.com
 * 2017-12-21 16:49
 */
class WriteExternalStoragePermissionHelper : Helper() {

    override fun permission(): String {
        return Manifest.permission.WRITE_EXTERNAL_STORAGE
    }

    override fun requestCode(): Int {
        return PERMISSION_REQUEST_CODE_WRITE_EXTERNAL_STORAGE
    }

    override fun permissionRequiredHint(): Int {
        return R.string.permission_required_storage
    }
}