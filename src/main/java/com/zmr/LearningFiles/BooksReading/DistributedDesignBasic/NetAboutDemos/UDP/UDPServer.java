package com.zmr.LearningFiles.BooksReading.DistributedDesignBasic.NetAboutDemos.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServer {

    private DatagramSocket socket;
    private byte[] buffer;

    public UDPServer(int port) throws SocketException {
        socket = new DatagramSocket(port);
        buffer = new byte[1024];
    }

    public void start() {
        System.out.println("UDP 服务器已启动，等待客户端发送消息...");

        while (true) {
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            try {
                socket.receive(packet);
                String message = new String(packet.getData(), 0, packet.getLength());
                System.out.println("收到客户端消息：" + message);

                // 回复客户端
                InetAddress clientAddress = packet.getAddress();
                int clientPort = packet.getPort();
                String replyMessage = "服务器已收到你的消息";
                byte[] sendData = replyMessage.getBytes();
                packet = new DatagramPacket(replyMessage.getBytes(), sendData.length, clientAddress, clientPort);
                socket.send(packet);

            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public static void main(String[] args) {
        try {
            UDPServer server = new UDPServer(12345);
            server.start();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}


