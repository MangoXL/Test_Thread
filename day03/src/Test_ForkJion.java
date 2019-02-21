import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class Test_ForkJion {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        MyTaks task = new MyTaks(0,100);
        ForkJoinTask<Integer> result = forkJoinPool.submit(task);
        System.out.println(result.get());
        forkJoinPool.shutdown();
    }
}
class MyTaks extends RecursiveTask<Integer>{
    private static final Integer ADJUST_VALUE = 10;
    private int begin ;
    private int end;
    private int result;
    public MyTaks(int begin,int end){
        this.begin = begin;
        this.end = end;
    }
    @Override
    protected Integer compute() {
        if((end - begin) <= ADJUST_VALUE){
            for(int i = begin; i <= end; i++){
                result = result + i;
            }
        }else {
            int middle = (begin + end) / 2;
            MyTaks task1 = new MyTaks(begin, middle);
            MyTaks task2 = new MyTaks(middle + 1, end);
            task1.fork();
            task2.fork();
            result = task1.join() + task2.join();
        }
        return result;
    }
}
