package com.hayukleung.mpermissions.lab;

import java.util.Locale;

/**
 * MPermissions
 * <p>
 * liangxiaxu@aobi.com
 * 2017-12-24 11:28
 */

public class Test {

    public static void main(String[] args) {
        int code = 0xffff;
        // from ffff to 0
        System.out.println(String.format(Locale.CHINA, "from %x to %x", code, code >> 16));
    }
}
