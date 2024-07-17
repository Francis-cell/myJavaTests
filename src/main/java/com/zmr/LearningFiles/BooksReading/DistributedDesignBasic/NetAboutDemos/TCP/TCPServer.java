package com.zmr.LearningFiles.BooksReading.DistributedDesignBasic.NetAboutDemos.TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void start(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("TCP 服务器已启动，等待客户端连接！");

            clientSocket = serverSocket.accept();
            System.out.println("客户端已连接：" + clientSocket.getRemoteSocketAddress());

            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("客户端发送：" + inputLine);
                out.println("服务器回复：我收到了你的消息 - " + inputLine);
                if (inputLine.equals("bye")) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TCPServer server = new TCPServer();
        server.start(12346);
    }
}
