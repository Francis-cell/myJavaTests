package com.zmr.LearningFiles.DynamicLearningAbout.Clock.VectorClock;

/**
 * <p> 定义节点类（进程） </p>
 */
class VectorProcess {
    private String processId;
    private VectorClock vectorClock;

    public VectorProcess(String processId) {
        this.processId = processId;
        this.vectorClock = new VectorClock();
        this.vectorClock.initialize(processId);
    }

    // 发送消息：递增自己的时钟并附上消息
    public VectorMessage sendMessage(String content) {
        vectorClock.increment(processId);  // 本地时钟递增
        vectorClock.printClock(processId); // 打印当前时钟
        System.out.println(processId + " sends message: '" + content + "'");
        return new VectorMessage(vectorClock, content); // 发送当前时钟和消息
    }

    // 接收消息：更新自己的时钟并合并收到的时钟值
    public void receiveMessage(VectorMessage message) {
        System.out.println(processId + " received message: '" + message.getContent() + "'");
        vectorClock.update(message.getClock()); // 合并接收到的时钟
        vectorClock.increment(processId);       // 本地时钟递增
        vectorClock.printClock(processId);      // 打印更新后的时钟
    }
}

