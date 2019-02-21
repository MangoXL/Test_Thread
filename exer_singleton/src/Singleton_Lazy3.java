/**
 * 静态内部类模式：
 * 在内部类被加载初始化时，才会创建INSTANCE实例对象
 * 静态内部类不会随着外部类的加载和初始化而初始化，它是要单独去创建和初始化的
 * 因为是在内部类创建和初始化时创建的，所以线程是安全的
 */
public class Singleton_Lazy3 {
    private Singleton_Lazy3(){}
    private static class Inner{
        private static final Singleton_Lazy3 INSTANCE = new Singleton_Lazy3();
    }
    public static Singleton_Lazy3 getINSTANCE(){
        return Inner.INSTANCE;
    }

    public static void main(String[] args) {
        Singleton_Lazy3 s1 = Singleton_Lazy3.getINSTANCE();
        Singleton_Lazy3 s2 = Singleton_Lazy3.getINSTANCE();
        System.out.println(s1 == s2);
        System.out.println(s1);
        System.out.println(s2);
    }
}
