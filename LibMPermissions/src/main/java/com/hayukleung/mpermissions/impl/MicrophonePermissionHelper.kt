package com.hayukleung.mpermissions.impl

import android.Manifest
import com.hayukleung.mpermissions.Helper
import com.hayukleung.mpermissions.PERMISSION_REQUEST_CODE_MICROPHONE
import com.hayukleung.mpermissions.R

/**
 * MPermissions
 *
 * liangxiaxu@aobi.com
 * 2017-12-21 17:54
 */
class MicrophonePermissionHelper : Helper() {

    override fun permission(): String {
        return Manifest.permission.RECORD_AUDIO
    }

    override fun requestCode(): Int {
        return PERMISSION_REQUEST_CODE_MICROPHONE
    }

    override fun permissionRequiredHint(): Int {
        return R.string.permission_required_microphone
    }
}