package com.hayukleung.mpermissions

import android.content.Context
import android.widget.Toast

/**
 * MPermissions
 *
 * liangxiaxu@aobi.com
 * 2017-12-21 17:05
 */
fun Context.toast(message: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, length).show()
}