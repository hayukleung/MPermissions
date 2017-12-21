package com.hayukleung.mpermissions.impl

import android.Manifest
import com.hayukleung.mpermissions.Helper
import com.hayukleung.mpermissions.PERMISSION_REQUEST_CODE_SMS

/**
 * MPermissions
 *
 * liangxiaxu@aobi.com
 * 2017-12-21 17:54
 */
object SMSPermissionHelper : Helper() {

    override fun permission(): String {
        return Manifest.permission.SEND_SMS
        // or return Manifest.permission.RECEIVE_SMS
        // or return Manifest.permission.READ_SMS
        // or return Manifest.permission.RECEIVE_WAP_PUSH
        // or return Manifest.permission.RECEIVE_MMS
    }

    override fun requestCode(): Int {
        return PERMISSION_REQUEST_CODE_SMS
    }
}