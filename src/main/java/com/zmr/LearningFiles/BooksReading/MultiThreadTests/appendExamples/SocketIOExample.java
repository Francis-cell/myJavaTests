package com.zmr.LearningFiles.BooksReading.MultiThreadTests.appendExamples;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * <p> 在并发编程中，如果一个线程正在执行同步的 Socket I/O 操作，例如通过 <code> Socket </code> 进行网络统信，而
 * 此时网络连接处于阻塞状态，线程会被阻塞等待数据到来或者数据的发送；</p>
 * <p> 在这种情况下，如果另一个线程调用了该线程的  <code> interrupt </code> 方法，那么被阻塞的线程的中断状态将会
 * 被设置，但它不会立即抛出 <code> InterruptedException </code></p>
 * <p>相反，它会继续等待，直到 Socket I/O 操作完成
 * 或发生其他可中断操作</p>
 */
public class SocketIOExample {
    public static void main(String[] args) {
        Thread serverThread = new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(8080);
                // 阻塞等待连接
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();

                int data;
                while ((data = inputStream.read()) != -1) {
                    // 处理数据
                    System.out.println("Received data: " + data);
                }

                // 关闭底层套接字（那么在后续执行 read 或者 write 等方法而被阻塞的线程，将会抛出 SocketException ）
                socket.close();
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        serverThread.start();

        // 主线程等待一段时间之后中断 serverThread
        try {
            Thread.sleep(1000);
            serverThread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
