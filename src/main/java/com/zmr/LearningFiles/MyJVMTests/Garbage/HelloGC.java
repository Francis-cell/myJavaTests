package main.java.com.zmr.LearningFiles.MyJVMTests.Garbage;

/**
 * @author 朱梦仁 franciszmr@foxmail.com
 * @version 1.0
 * @date 2023/2/4 11:11
 */
import java.util.List;
import java.util.LinkedList;
public class HelloGC {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        System.out.println("HelloGc!");
        List list = new LinkedList();
        for(;;) {
            byte[] b = new byte[1024*1024];
            list.add(b);
        }
    }
}
