package com.hayukleung.mpermissions.impl

import android.Manifest
import com.hayukleung.mpermissions.Helper
import com.hayukleung.mpermissions.PERMISSION_REQUEST_CODE_PHONE
import com.hayukleung.mpermissions.R

/**
 * MPermissions
 *
 * liangxiaxu@aobi.com
 * 2017-12-21 17:54
 */
object PhonePermissionHelper : Helper() {

    override fun permission(): String {
        return Manifest.permission.READ_PHONE_STATE
        // or return Manifest.permission.CALL_PHONE
        // or return Manifest.permission.READ_CALL_LOG
        // or return Manifest.permission.WRITE_CALL_LOG
        // or return Manifest.permission.ADD_VOICEMAIL
        // or return Manifest.permission.USE_SIP
        // or return Manifest.permission.PROCESS_OUTGOING_CALLS
    }

    override fun requestCode(): Int {
        return PERMISSION_REQUEST_CODE_PHONE
    }

    override fun permissionRequiredHint(): Int {
        return R.string.permission_required_phone
    }
}