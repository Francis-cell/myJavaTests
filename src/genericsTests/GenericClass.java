package genericsTests;

/**
 * @ClassName GenericClass
 * @Description 泛型类
 * @Author zhumengren
 * @Date 2022/4/19 9:25
 * @Email zhumengren@sinosoft.com
 * @Version 1.0
 **/
public class GenericClass<T> {
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
