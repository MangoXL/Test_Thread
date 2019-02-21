import java.util.concurrent.*;

/**
 * 线程安全，适合多线程
 */
public class Singleton_Lazy2 {
    private static Singleton_Lazy2 INSTANCE;
    private Singleton_Lazy2(){}

    public static Singleton_Lazy2 getINSTANCE(){
        if (INSTANCE == null) {
            synchronized (Singleton_Lazy2.class){
                if(INSTANCE == null){
                    INSTANCE = new Singleton_Lazy2();
                }
            }
        }
        return INSTANCE;
    }
}
class Test5{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Singleton_Lazy2> c = new Callable<Singleton_Lazy2>() {
            @Override
            public Singleton_Lazy2 call() throws Exception {
                try { Thread.sleep(1000);} catch (InterruptedException e) { e.printStackTrace(); }
                return Singleton_Lazy2.getINSTANCE();
            }
        };
        ExecutorService es = Executors.newFixedThreadPool(2);
        Future<Singleton_Lazy2> f1 = es.submit(c);
        Future<Singleton_Lazy2> f2 = es.submit(c);
        Singleton_Lazy2 s1 = f1.get();
        Singleton_Lazy2 s2 = f2.get();
        System.out.println(s1 == s2);
        System.out.println(s1);
        System.out.println(s2);
        es.shutdown();
    }
}

