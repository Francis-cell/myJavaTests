package com.zmr.LearningFiles.DynamicLearningAbout.Clock.VectorClock;

/**
 * <p> 消息类 </p>
 */
class VectorMessage {
    private VectorClock clock;
    private String content;

    public VectorMessage(VectorClock clock, String content) {
        this.clock = clock;
        this.content = content;
    }

    public VectorClock getClock() {
        return clock;
    }

    public String getContent() {
        return content;
    }
}
