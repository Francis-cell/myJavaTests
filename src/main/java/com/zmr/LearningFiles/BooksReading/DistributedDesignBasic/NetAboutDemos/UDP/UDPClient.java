package com.zmr.LearningFiles.BooksReading.DistributedDesignBasic.NetAboutDemos.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPClient {

    private DatagramSocket socket;
    private InetAddress address;
    private byte[] buffer;

    public UDPClient(String address, int port) throws SocketException, IOException {
        socket = new DatagramSocket();
        this.address = InetAddress.getByName(address);
        buffer = new byte[1024];
    }

    public void send(String message) throws IOException {
        buffer = message.getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 12345);
        socket.send(packet);
    }

    public String receive() throws IOException {
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        socket.receive(packet);
        return new String(packet.getData(), 0, packet.getLength());
    }

    public void close() {
        socket.close();
    }

    public static void main(String[] args) {
        try {
            UDPClient client = new UDPClient("localhost", 12345);
            client.send("你好，服务器！");
            String reply = client.receive();
            System.out.println("服务器回复：" + reply);
            client.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


