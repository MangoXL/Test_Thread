/**
 * 饿汉式单例：直接创建对象，不存在线程安全问题
 * 直接实例化饿汉式（简洁直观）
 * 1、构造器自由化
 * 2、自行创建，并用静态变量保存
 * 3、向外提供这个实例
 * 4、强调这个一个单例，我们可以用final修饰
 */
public class Singleton_Hungry1 {
    public static final Singleton_Hungry1 INSTANCE = new Singleton_Hungry1();
    private Singleton_Hungry1(){

    }
}
class Test1{
    public static void main(String[] args) {
        Singleton_Hungry1 s = Singleton_Hungry1.INSTANCE;
        System.out.println(s);
    }
}
