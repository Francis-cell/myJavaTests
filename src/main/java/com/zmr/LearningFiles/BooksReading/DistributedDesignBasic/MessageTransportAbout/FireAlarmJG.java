package com.zmr.LearningFiles.BooksReading.DistributedDesignBasic.MessageTransportAbout;

import org.jgroups.JChannel;
import org.jgroups.Message;

public class FireAlarmJG {
    public void raise() {
        try {
            JChannel channel = new JChannel();
            channel.connect("AlarmChannel");
            // 只传递目标地址和消息体
            Message msg = new Message(null, "Fire!");
            // 关闭频道
            channel.send(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FireAlarmJG fireAlarmJG = new FireAlarmJG();
        fireAlarmJG.raise();
    }
}
