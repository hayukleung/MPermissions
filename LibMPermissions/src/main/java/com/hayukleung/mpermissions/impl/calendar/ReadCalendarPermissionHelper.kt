package com.hayukleung.mpermissions.impl.calendar

import android.Manifest
import com.hayukleung.mpermissions.Helper
import com.hayukleung.mpermissions.PERMISSION_REQUEST_CODE_READ_CALENDAR
import com.hayukleung.mpermissions.R

/**
 * MPermissions
 *
 * liangxiaxu@aobi.com
 * 2017-12-21 17:54
 */
class ReadCalendarPermissionHelper : Helper() {

    override fun permission(): String {
        return Manifest.permission.READ_CALENDAR
    }

    override fun requestCode(): Int {
        return PERMISSION_REQUEST_CODE_READ_CALENDAR
    }

    override fun permissionRequiredHint(): Int {
        return R.string.permission_required_calendar
    }
}