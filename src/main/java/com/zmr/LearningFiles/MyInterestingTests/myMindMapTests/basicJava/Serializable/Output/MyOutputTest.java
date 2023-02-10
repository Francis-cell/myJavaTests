package main.java.com.zmr.LearningFiles.MyInterestingTests.myMindMapTests.basicJava.Serializable.Output;

import main.java.com.zmr.LearningFiles.MyInterestingTests.myMindMapTests.basicJava.Serializable.User;

import java.io.*;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2022/11/29 12:19
 */
public class MyOutputTest {
    public static void main(String[] args) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("D:\\Files\\main.java.com.zmr.LearningFiles\\myJavaTests\\src\\main.java.com.zmr.LearningFiles.MyInterestingTests.myMindMapTests\\basicJava\\Serializable\\Files\\temp.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            User user = new User();
            user.setAge(20);
            user.setName("小黑");
            // 输出文件
            objectOutputStream.writeObject(user);
            objectOutputStream.flush();
            objectOutputStream.close();

            user.setName("小白");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
