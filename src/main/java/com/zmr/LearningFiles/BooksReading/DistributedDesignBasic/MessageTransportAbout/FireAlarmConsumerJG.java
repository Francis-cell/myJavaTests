//package com.zmr.LearningFiles.BooksReading.DistributedDesignBasic.MessageTransportAbout;
//
//import org.jgroups.JChannel;
//import org.jgroups.Message;
//import org.jgroups.ReceiverAdapter;
//import org.jgroups.View;
//
//import java.util.concurrent.BlockingQueue;
//import java.util.concurrent.LinkedBlockingQueue;
//
//public class FireAlarmConsumerJG extends ReceiverAdapter {
//    private JChannel channel;
//    private final BlockingQueue<String> messageQueue = new LinkedBlockingQueue<>();
//
//    public void start() throws Exception {
//        channel = new JChannel();
//        channel.setReceiver(this);
//        channel.connect("AlarmChannel");
//        System.out.println("FireAlarmConsumerJG started and connected to channel.");
//    }
//
//    @Override
//    public void receive(Message msg) {
//        String message = (String) msg.getObject();
//        System.out.println("Received message: " + message);
//        try {
//            messageQueue.put(message);
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void viewAccepted(View newView) {
//        System.out.println("** view: " + newView);
//    }
//
//    public void stop() {
//        if (channel != null) {
//            channel.close();
//        }
//    }
//
//    public String await() {
//        try {
//            return messageQueue.take();
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    public static void main(String[] args) throws Exception {
//        FireAlarmConsumerJG consumer = new FireAlarmConsumerJG();
//        consumer.start();
//        // Keep the application running to receive messages
//        Thread.sleep(1000000);
//        consumer.stop();
//        // String msg = consumer.await();
//        // System.out.println("Alarm received: " + msg);
//    }
//}
