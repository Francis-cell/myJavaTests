package com.zmr.LearningFiles.BooksReading.DistributedDesignBasic.NetAboutDemos.Multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastSender {
    public static void main(String[] args) throws IOException {
        MulticastSocket multicastSocket = null;
        try {
            // 创建MulticastSocket并绑定到端口
            multicastSocket = new MulticastSocket();
            // 设置多播组地址
            InetAddress group = InetAddress.getByName("230.0.0.0");

            // 发送数据
            String message = "Hello, multicast!";
            byte[] buffer = message.getBytes();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, 4446);

            multicastSocket.send(packet);
            System.out.println("多播消息已发送: " + message);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (multicastSocket != null && !multicastSocket.isClosed()) {
                multicastSocket.close();
            }
        }
    }
}
