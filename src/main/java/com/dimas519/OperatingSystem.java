package com.dimas519;

import org.apache.commons.lang3.SystemUtils;

public class OperatingSystem {
    public enum OS{
        WINDOWS,MAC_OS,LINUX;
    }
    private static  OS os;

    public OperatingSystem (){


        if(SystemUtils.IS_OS_WINDOWS){
            this.os=OS.WINDOWS;
        }else if(SystemUtils.IS_OS_MAC){
            this.os=OS.MAC_OS;
        }else{
            this.os=OS.LINUX;
        }
    }

    public static OS getOS() {
        return os;
    }
}
