package com.hayukleung.mpermissions

/**
 * MPermissions
 *
 * liangxiaxu@aobi.com
 * 2017-12-21 15:47
 */
interface RequestPermissionsDelegate {

    fun onRequestPermissionsResult(permissions: Array<out String>, grantResults: IntArray)
}