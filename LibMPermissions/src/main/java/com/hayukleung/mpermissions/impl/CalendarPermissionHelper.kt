package com.hayukleung.mpermissions.impl

import android.Manifest
import com.hayukleung.mpermissions.Helper
import com.hayukleung.mpermissions.PERMISSION_REQUEST_CODE_CALENDAR

/**
 * MPermissions
 *
 * liangxiaxu@aobi.com
 * 2017-12-21 17:54
 */
object CalendarPermissionHelper : Helper() {

    override fun permission(): String {
        return Manifest.permission.READ_CALENDAR
        // or return Manifest.permission.WRITE_CALENDAR
    }

    override fun requestCode(): Int {
        return PERMISSION_REQUEST_CODE_CALENDAR
    }
}