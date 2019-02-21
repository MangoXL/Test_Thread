import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Test_CompletableFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //异步函数调用，无返回值
        CompletableFuture<Void> c1 = CompletableFuture.runAsync(() -> {
            System.out.println("--------c1--------");
        });

        //异步函数调用，有返回值
        CompletableFuture<Integer> c2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("----------c2----------");
            int i = 1/0;
            return 666;
        });
       // System.out.println(c2.get());

        Integer result = c2.whenComplete((t, u) -> {
            System.out.println("result :" + t);
        }).exceptionally((e) -> {
            System.out.println("发生异常：" + e);
            return -1;
        }).get();
        System.out.println("result :" +result);
    }
}

