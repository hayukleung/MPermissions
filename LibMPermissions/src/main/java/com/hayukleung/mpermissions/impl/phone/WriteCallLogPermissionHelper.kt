package com.hayukleung.mpermissions.impl.phone

import android.Manifest
import com.hayukleung.mpermissions.Helper
import com.hayukleung.mpermissions.PERMISSION_REQUEST_CODE_WRITE_CALL_LOG
import com.hayukleung.mpermissions.R

/**
 * MPermissions
 *
 * liangxiaxu@aobi.com
 * 2017-12-21 17:54
 */
class WriteCallLogPermissionHelper : Helper() {

    override fun permission(): String {
        return Manifest.permission.WRITE_CALL_LOG
    }

    override fun requestCode(): Int {
        return PERMISSION_REQUEST_CODE_WRITE_CALL_LOG
    }

    override fun permissionRequiredHint(): Int {
        return R.string.permission_required_phone
    }
}