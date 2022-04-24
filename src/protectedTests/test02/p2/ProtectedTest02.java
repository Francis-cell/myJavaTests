package protectedTests.test02.p2;

import protectedTests.test02.p1.MyObject;

/**
 * @ClassName ProtectedTest02
 * @Description ProtectedTest02测试类
 * @Author zhumengren
 * @Date 2022/4/18 13:04
 * @Email zhumengren@sinosoft.com
 * @Version 1.0
 **/
public class ProtectedTest02 extends MyObject {
    public static void main(String[] args) throws CloneNotSupportedException {
        MyObject myObject = new MyObject();
        // 报错内容：'clone()' has protected access in 'protectedTests.test02.p1.MyObject'
        // myObject.clone();

        ProtectedTest02 pt2 = new ProtectedTest02();
        pt2.clone();
    }
}
