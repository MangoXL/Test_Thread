import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * 轮询FutureTask.isDone()这个方法一般放在最后，因为它会产生阻塞，直到该FutureTask不再阻塞才会往下走
 */
public class Test_Callable_isDone {
    public static void main(String[] args) {
        FutureTask<Integer> ft = new FutureTask<Integer>(() -> {
            try { TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) { e.printStackTrace(); }
            return 666;
        });
        new Thread(ft,"FutureTask").start();
        System.out.println(Thread.currentThread().getName() + "\t 123");
        //轮询
        while(!ft.isDone()){
            System.out.println("wait...");
        }
    }
}
