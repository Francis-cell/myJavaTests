package com.zmr.LearningFiles.DynamicLearningAbout.Clock.LamportClock;

/**
 * <p> 定义节点类（进程） </p>
 */
class LamportProcess {
    private int clock;
    private String name;

    public LamportProcess(String name) {
        this.clock = 0; // 初始时钟为 0
        this.name = name;
    }

    // 发送消息方法：增加本地时钟并附上消息
    public Message sendMessage(String content) {
        clock++;  // 本地事件发生时，时钟递增
        System.out.println(name + " sends message: '" + content + "' at time: " + clock);
        return new Message(clock, content); // 返回包含时钟值的消息
    }

    // 接收消息方法：接收外部消息并调整时钟
    public void receiveMessage(Message message) {
        clock = Math.max(clock, message.getTimestamp()) + 1; // 更新时钟值
        System.out.println(name + " received message: '" + message.getContent() + "' and updated time to: " + clock);
    }

    // 打印当前时钟
    public int getClock() {
        return clock;
    }
}
