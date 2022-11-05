package SocketCommunicateTests;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @ClassName MyServerTest
 * @Description Socket通信服务端
 * @Author zhumengren
 * @Date 2022/10/23 13:50
 * @Email zhumengren@sinosoft.com
 * @Version 1.0
 **/
public class MyServerTest {
    public static void main(String[] args) {
        try {
            // 打开Socket服务端对应的端口
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("服务端Socket通信端口已经打开，等待客户端进行链接！");
            // 使用accept阻塞，等待客户端进行连接
            Socket socket = serverSocket.accept();
            System.out.println("通信开始！");
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            // 初始化Reader、Writer、ReaderBuffer方法
            InputStreamReader isReader = new InputStreamReader(is);
            BufferedReader bufferedReader = new BufferedReader(isReader);
            PrintWriter printWriter = new PrintWriter(os);

            // 声明临界区r1
            Runnable r1 = new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            // 接受信息
                            String str;
                            str = bufferedReader.readLine();
                            System.out.println("读取的信息为：" + str);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };

            // 声明临界区r2
            Runnable r2 = new Runnable() {
                @Override
                public void run() {
                    // 返回信息
                    while(true) {
                        Scanner sc = new Scanner(System.in);
                        System.out.println("请输入需要传入的信息！");
                        String str = sc.nextLine();
                        // 打印出信息
                        printWriter.println(str);
                        printWriter.flush();
                    }
                }
            };

            // 创建两个线程，分别用来运行r1和r2
            Thread readThread = new Thread(r1);
            Thread writeThread = new Thread(r2);
            readThread.start();
            writeThread.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
