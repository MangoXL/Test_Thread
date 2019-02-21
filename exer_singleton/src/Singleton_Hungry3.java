import java.io.IOException;
import java.util.Properties;

/**
 * 饿汉式单例：直接创建对象，不存在线程安全问题
 * 静态代码块饿汉式（适合复杂实例化）
 */
public class Singleton_Hungry3 {
    public static final Singleton_Hungry3 INSTANCE;
    private String info;
    static {
        try {
            Properties pro = new Properties();
            pro.load(Singleton_Hungry3.class.getClassLoader().getResourceAsStream("info.properties"));
            INSTANCE = new Singleton_Hungry3(pro.getProperty("info"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private Singleton_Hungry3(String info){
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Singleton_Hungry3{" +
                "info='" + info + '\'' +
                '}';
    }
}
class Test3{
    public static void main(String[] args) {
        Singleton_Hungry3 s = Singleton_Hungry3.INSTANCE;
        System.out.println(s);
    }
}
