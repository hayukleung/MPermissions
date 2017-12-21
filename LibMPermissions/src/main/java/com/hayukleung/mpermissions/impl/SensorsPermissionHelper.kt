package com.hayukleung.mpermissions.impl

import android.Manifest
import android.support.annotation.RequiresApi
import com.hayukleung.mpermissions.Helper
import com.hayukleung.mpermissions.PERMISSION_REQUEST_CODE_SENSORS

/**
 * MPermissions
 *
 * liangxiaxu@aobi.com
 * 2017-12-21 17:54
 */
@RequiresApi(20)
object SensorsPermissionHelper : Helper() {

    override fun permission(): String {
        return Manifest.permission.BODY_SENSORS
    }

    override fun requestCode(): Int {
        return PERMISSION_REQUEST_CODE_SENSORS
    }
}