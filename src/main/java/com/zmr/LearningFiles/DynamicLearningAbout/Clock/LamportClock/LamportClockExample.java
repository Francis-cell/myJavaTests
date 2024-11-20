package com.zmr.LearningFiles.DynamicLearningAbout.Clock.LamportClock;

/**
 * <p> 测试节点之间的通信 </p>
 */
public class LamportClockExample {
    public static void main(String[] args) {
        // 创建两个进程
        LamportProcess process1 = new LamportProcess("Process 1");
        LamportProcess process2 = new LamportProcess("Process 2");

        // Process 1 发送消息
        Message messageFromP1 = process1.sendMessage("Hello from P1");

        // Process 2 接收消息并调整时钟
        process2.receiveMessage(messageFromP1);

        // Process 2 发送回复消息
        Message messageFromP2 = process2.sendMessage("Hello from P2");

        // Process 1 接收消息并调整时钟
        process1.receiveMessage(messageFromP2);

        // 查看最终的时钟值
        System.out.println("Final Clock of Process 1: " + process1.getClock());
        System.out.println("Final Clock of Process 2: " + process2.getClock());
    }
}

