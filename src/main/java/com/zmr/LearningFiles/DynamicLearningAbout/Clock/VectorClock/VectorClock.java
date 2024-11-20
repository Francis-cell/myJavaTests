package com.zmr.LearningFiles.DynamicLearningAbout.Clock.VectorClock;

/**
 * <p> 定义向量时钟类 </p>
 */
import java.util.HashMap;
import java.util.Map;

class VectorClock {
    private Map<String, Integer> clock; // 每个节点的时钟值存储在一个 Map 中

    public VectorClock() {
        this.clock = new HashMap<>();
    }

    // 初始化时钟，给每个节点一个初始值 0
    public void initialize(String processId) {
        clock.put(processId, 0);
    }

    // 更新时钟值
    public void increment(String processId) {
        clock.put(processId, clock.get(processId) + 1);
    }

    // 获取时钟值
    public int getTime(String processId) {
        return clock.getOrDefault(processId, 0);
    }

    // 在接收到消息时，合并向量时钟
    public void update(VectorClock receivedClock) {
        for (Map.Entry<String, Integer> entry : receivedClock.clock.entrySet()) {
            String processId = entry.getKey();
            int receivedTime = entry.getValue();
            clock.put(processId, Math.max(clock.getOrDefault(processId, 0), receivedTime));
        }
    }

    // 打印时钟状态
    public void printClock(String processId) {
        System.out.println(processId + " current vector clock: " + clock);
    }

    // 获取整个时钟向量
    public Map<String, Integer> getClock() {
        return clock;
    }
}

