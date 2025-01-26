package com.belajartestng.drivers.utilities;

public class BrowserType {
    public static final String CHROME = "chrome";
    public static final String FIREFOX = "firefox";

    private BrowserType(){
        throw new UnsupportedOperationException("This is a constant class and cannot be instantiate");
    }
}
