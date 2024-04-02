package com.zmr.LearningFiles.OwnTests.UtilsTests;

public class ServerUtilsTest {
    public static void main(String[] args) {
        String ip = "192.127.168.23";
        ip = ip.substring(ip.lastIndexOf(".") + 1);
        System.out.println(ip);
    }
}
