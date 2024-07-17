package com.zmr.LearningFiles.BooksReading.DistributedDesignBasic.NetAboutDemos;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
    public static void main(String[] args) {
        try {
            // 获取本地的 InetAddress 实例
            InetAddress localAddress = InetAddress.getLocalHost();
            System.out.println("本地主机名：" + localAddress.getHostName());
            System.out.println("本地 IP 地址：" + localAddress.getHostAddress());

            // 根据主机名获取 InetAddress 实例
            InetAddress remoteAddress = InetAddress.getByName("www.baidu.com");
            System.out.println("远程主机名：" + remoteAddress.getHostName());
            System.out.println("远程 IP 地址：" + remoteAddress.getHostAddress());

            // 检查地址是否可达
            System.out.println("远程主机是否可达：" + remoteAddress.isReachable(5000));

            // 获取自己数组形式的 IP 地址
            byte[] bytes = remoteAddress.getAddress();
            for (byte b : bytes) {
                System.out.print(b & 0xFF);
                System.out.print(".");
            }
            System.out.println();

            // 判断是否为广播地址
            System.out.println("是否为广播地址：" + InetAddress.getByAddress(bytes).isMulticastAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
