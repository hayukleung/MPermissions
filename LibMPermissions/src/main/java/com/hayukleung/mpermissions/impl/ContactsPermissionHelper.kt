package com.hayukleung.mpermissions.impl

import android.Manifest
import com.hayukleung.mpermissions.Helper
import com.hayukleung.mpermissions.PERMISSION_REQUEST_CODE_CONTACTS

/**
 * MPermissions
 *
 * liangxiaxu@aobi.com
 * 2017-12-21 16:49
 */
object ContactsPermissionHelper : Helper() {

    override fun permission(): String {
        return Manifest.permission.READ_CONTACTS
        // or return Manifest.permission.WRITE_CONTACTS
        // or return Manifest.permission.GET_ACCOUNTS
    }

    override fun requestCode(): Int {
        return PERMISSION_REQUEST_CODE_CONTACTS
    }
}