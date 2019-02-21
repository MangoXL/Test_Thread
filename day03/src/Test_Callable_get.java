import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * 阻塞:FutureTask.get()这个方法一般放在最后，因为它产生阻塞，不出结果不会继续往下走
 */
public class Test_Callable_get {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask ft = new FutureTask<Integer>(() -> {
            try { TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) { e.printStackTrace(); }
            return 666;
        });
        new Thread(ft,"FutureTask").start();
        System.out.println(Thread.currentThread().getName() + "\t123");
        //阻塞:FutureTask.get()这个方法一般放在最后，因为它产生阻塞，不出结果不会继续往下走
        System.out.println(ft.get());
    }
}
