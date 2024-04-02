package com.zmr.MiddleWare.LogAbout.Log4J.codeDemo;

import java.net.URL;

public class Log4jConfigCheck {
    public static void main(String[] args) {
        URL log4jConfigUrl = Log4jConfigCheck.class.getClassLoader().getResource("log4j2.xml");
        if (log4jConfigUrl == null) {
            System.out.println("Log4j configuration file not found!");
        } else {
            System.out.println("Log4j configuration file found at: " + log4jConfigUrl);
        }
    }
}

