package com.zmr.LearningFiles.DynamicLearningAbout.Clock.VectorClock;

/**
 * <p> 测试进程之间的通信 </p>
 */
public class VectorClockExample {
    public static void main(String[] args) {
        // 创建两个进程
        VectorProcess process1 = new VectorProcess("Process1");
        VectorProcess process2 = new VectorProcess("Process2");

        // Process1 发送消息
        VectorMessage messageFromP1 = process1.sendMessage("Hello from P1");

        // Process2 接收消息并调整时钟
        process2.receiveMessage(messageFromP1);

        // Process2 发送回复消息
        VectorMessage messageFromP2 = process2.sendMessage("Hello from P2");

        // Process1 接收消息并调整时钟
        process1.receiveMessage(messageFromP2);
    }
}

