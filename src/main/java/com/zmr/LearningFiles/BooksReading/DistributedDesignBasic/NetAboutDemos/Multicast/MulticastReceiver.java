package com.zmr.LearningFiles.BooksReading.DistributedDesignBasic.NetAboutDemos.Multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastReceiver {
    public static void main(String[] args) throws IOException {
        MulticastSocket multicastSocket = null;
        try {
            // 创建MulticastSocket并绑定到端口
            multicastSocket = new MulticastSocket(4446);
            // 设置多播组地址
            InetAddress group = InetAddress.getByName("230.0.0.0");

            // 加入多播组
            multicastSocket.joinGroup(group);

            // 接收数据
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            System.out.println("等待多播消息...");

            multicastSocket.receive(packet);
            String received = new String(packet.getData(), 0, packet.getLength());
            System.out.println("接收到多播消息: " + received);

            // 退出多播组
            multicastSocket.leaveGroup(group);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (multicastSocket != null && !multicastSocket.isClosed()) {
                multicastSocket.close();
            }
        }
    }
}
