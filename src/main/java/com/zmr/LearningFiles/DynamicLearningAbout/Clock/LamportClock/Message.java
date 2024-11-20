package com.zmr.LearningFiles.DynamicLearningAbout.Clock.LamportClock;

/**
 * <p> 定义消息类 </p>
 */
class Message {
    int timestamp;
    String content;

    public Message(int timestamp, String content) {
        this.timestamp = timestamp;
        this.content = content;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public String getContent() {
        return content;
    }
}

