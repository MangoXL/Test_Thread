import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Executors.newFixedThreadPool()：固定线程数的线程池
 * Executors.newSingleThreadExecutor()：一个线程的线程池
 * Executors.newCachedThreadPool()：可扩容的多线程数的线程池，按需求取线程
 */
public class Test_ThreadPool {
    public static void main(String[] args) {
        //ExecutorService es = Executors.newFixedThreadPool(3);
        //ExecutorService es = Executors.newSingleThreadExecutor();
        ExecutorService es = Executors.newCachedThreadPool();
        for(int i = 1; i <= 10; i++){
            es.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "\t执行业务！");
            });
        }
        es.shutdown();
    }
}
