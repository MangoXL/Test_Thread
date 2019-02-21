import com.sun.istack.internal.FinalArrayList;

import java.util.concurrent.*;

/**
 * 懒汉式单例
 * 1、构造器私有化
 * 2、用一个静态变量来保存这个实例
 * 3、提供一个静态方法，获取这个实例对象
 *
 * 该方法只适合单线程，如果是多线程的话，会出现线程安全问题，导致获取的对象不是同一个
 */
public class Singleton_Lazy1 {
    private static Singleton_Lazy1 INSTANCE;
    private Singleton_Lazy1(){}

    public static Singleton_Lazy1 getINSTANCE() {
        if(INSTANCE == null){
            try { Thread.sleep(1000);} catch (InterruptedException e) { e.printStackTrace(); }
            INSTANCE = new Singleton_Lazy1();
        }
        return INSTANCE;
    }
}
class Test4{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Singleton_Lazy1 s1 = Singleton_Lazy1.getINSTANCE();
        Singleton_Lazy1 s2 = Singleton_Lazy1.getINSTANCE();
        System.out.println(s1 == s2);
        System.out.println(s1);
        System.out.println(s2);

        /*会出现线程安全示例
        Callable<Singleton_Lazy1> c = new Callable<Singleton_Lazy1>() {
            @Override
            public Singleton_Lazy1 call() throws Exception {
                return Singleton_Lazy1.getINSTANCE();
            }
        };
        ExecutorService es = Executors.newFixedThreadPool(2);
        Future<Singleton_Lazy1> f1 = es.submit(c);
        Future<Singleton_Lazy1> f2 = es.submit(c);
        Singleton_Lazy1 s1 = f1.get();
        Singleton_Lazy1 s2 = f2.get();
        System.out.println(s1 == s2);
        System.out.println(s1);
        System.out.println(s2);
        es.shutdown();
        */
    }
}
