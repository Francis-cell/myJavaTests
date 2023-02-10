package main.java.com.zmr.LearningFiles.BasicJava.SocketCommunicateTests;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @ClassName MyClientTest
 * @Description Socket通信客户端
 * @Author zhumengren
 * @Date 2022/10/23 13:50
 * @Email zhumengren@sinosoft.com
 * @Version 1.0
 **/
public class MyClientTest {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 8888);
            System.out.println("客户端-开始通信过程！");
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(is);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            PrintWriter printWriter = new PrintWriter(os);

            // 声明临界区r1
            Runnable r1 = new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            // 发送信息
                            Scanner sc = new Scanner(System.in);
                            System.out.println("请输入你想对服务端说的话：");
                            String str = sc.nextLine();
                            printWriter.println(str);
                            printWriter.flush();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            };

            // 声明临界区r2
            Runnable r2 = new Runnable() {
                @Override
                public void run() {
                    // 接受发送的信息
                    while (true) {
                        String str;
                        try {
                            str = bufferedReader.readLine();
                            System.out.println("新消息:" + str);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };

            Thread readThread = new Thread(r1);
            Thread writeThread = new Thread(r2);
            readThread.start();
            writeThread.start();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
