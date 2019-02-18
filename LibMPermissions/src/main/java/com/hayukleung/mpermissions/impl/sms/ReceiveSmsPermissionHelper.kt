package com.hayukleung.mpermissions.impl.sms

import android.Manifest
import com.hayukleung.mpermissions.Helper
import com.hayukleung.mpermissions.PERMISSION_REQUEST_CODE_RECEIVE_SMS
import com.hayukleung.mpermissions.R

/**
 * MPermissions
 *
 * liangxiaxu@aobi.com
 * 2017-12-21 17:54
 */
class ReceiveSmsPermissionHelper : Helper() {

    override fun permission(): String {
        return Manifest.permission.RECEIVE_SMS
    }

    override fun requestCode(): Int {
        return PERMISSION_REQUEST_CODE_RECEIVE_SMS
    }

    override fun permissionRequiredHint(): Int {
        return R.string.permission_required_sms
    }
}