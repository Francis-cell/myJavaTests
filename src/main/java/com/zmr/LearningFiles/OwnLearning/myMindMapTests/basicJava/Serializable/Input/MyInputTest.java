// package com.zmr.LearningFiles.OwnLearning.myMindMapTests.basicJava.Serializable.Input;
//
// import java.io.FileInputStream;
// import java.io.FileNotFoundException;
// import java.io.IOException;
// import java.io.ObjectInputStream;
//
// /**
//  * @author 朱梦仁 franciszmr@foxmail.com
//  * @version 1.0
//  * @date 2022/11/29 20:55
//  */
// public class MyInputTest {
//     public static void main(String[] args) {
//         try {
//             FileInputStream fileInputStream = new FileInputStream("D:\\Files\\main.java.com.zmr.LearningFiles\\myJavaTests\\src\\main.java.com.zmr.LearningFiles.MyInterestingTests.myMindMapTests\\basicJava\\Serializable\\Files\\temp.txt");
//             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//
//             User user = (User) objectInputStream.readObject();
//             System.out.println(user.getName());
//             System.out.println(user.getAge());
//             System.out.println(user.getSex());
//         } catch (FileNotFoundException e) {
//             e.printStackTrace();
//         } catch (IOException e) {
//             e.printStackTrace();
//         } catch (ClassNotFoundException e) {
//             e.printStackTrace();
//         }
//
//     }
// }
