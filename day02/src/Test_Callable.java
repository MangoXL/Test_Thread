import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test_Callable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //FutureTask<Integer> futureTask = new FutureTask<Integer>(new MyThread());
        FutureTask<Integer> futureTask = new FutureTask<Integer>(() -> {
            System.out.println("FutureTask with Lamdba");
            return 666;
        });
        Thread t1 = new Thread(futureTask,"A");
        t1.start();
        System.out.println("value :" + futureTask.get());

    }
}

class MyThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("call 执行了！");
        return 123;
    }
}
