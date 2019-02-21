/**
 * 饿汉式单例：直接创建对象，不存在线程安全问题
 * 枚举类（最简洁）
 * 枚举类型，表示该类的对象是有限的几个，我们可以限定为一个，就成了单例
 */
public enum Singleton_Hungry2 {
    INSTANCE;
}

class Test2{
    public static void main(String[] args) {
        Singleton_Hungry2 s = Singleton_Hungry2.INSTANCE;
        System.out.println(s);
    }
}
