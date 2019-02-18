package com.hayukleung.mpermissions.impl.contacts

import android.Manifest
import com.hayukleung.mpermissions.Helper
import com.hayukleung.mpermissions.PERMISSION_REQUEST_CODE_GET_ACCOUNTS
import com.hayukleung.mpermissions.R

/**
 * MPermissions
 *
 * liangxiaxu@aobi.com
 * 2017-12-21 16:49
 */
class GetAccountsPermissionHelper : Helper() {

    override fun permission(): String {
        return Manifest.permission.GET_ACCOUNTS
    }

    override fun requestCode(): Int {
        return PERMISSION_REQUEST_CODE_GET_ACCOUNTS
    }

    override fun permissionRequiredHint(): Int {
        return R.string.permission_required_contacts
    }
}