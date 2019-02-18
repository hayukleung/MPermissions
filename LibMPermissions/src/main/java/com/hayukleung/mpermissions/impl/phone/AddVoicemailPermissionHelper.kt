package com.hayukleung.mpermissions.impl.phone

import android.Manifest
import com.hayukleung.mpermissions.Helper
import com.hayukleung.mpermissions.PERMISSION_REQUEST_CODE_ADD_VOICEMAIL
import com.hayukleung.mpermissions.R

/**
 * MPermissions
 *
 * liangxiaxu@aobi.com
 * 2017-12-21 17:54
 */
class AddVoicemailPermissionHelper : Helper() {

    override fun permission(): String {
        return Manifest.permission.ADD_VOICEMAIL
    }

    override fun requestCode(): Int {
        return PERMISSION_REQUEST_CODE_ADD_VOICEMAIL
    }

    override fun permissionRequiredHint(): Int {
        return R.string.permission_required_phone
    }
}