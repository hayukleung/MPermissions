package com.hayukleung.mpermissions.impl.phone

import android.Manifest
import com.hayukleung.mpermissions.Helper
import com.hayukleung.mpermissions.PERMISSION_REQUEST_CODE_CALL_PHONE
import com.hayukleung.mpermissions.R

/**
 * MPermissions
 *
 * liangxiaxu@aobi.com
 * 2017-12-21 17:54
 */
class CallPhonePermissionHelper : Helper() {

    override fun permission(): String {
        return Manifest.permission.CALL_PHONE
    }

    override fun requestCode(): Int {
        return PERMISSION_REQUEST_CODE_CALL_PHONE
    }

    override fun permissionRequiredHint(): Int {
        return R.string.permission_required_phone
    }
}