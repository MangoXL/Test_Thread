import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * offer(e,time,unit):添加元素，设置超时时间，过时如果阻塞队列还是已满状态，返回false
 * poll(time,unit):移除元素，设置超时时间，过时如果阻塞队列还是已空状态，返回null
 */
public class Test_BlockingQueue_TimeOut {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue(3);
        blockingQueue.offer("a");
        blockingQueue.add("b");
        blockingQueue.add("c");
        System.out.println(blockingQueue.offer("1", 2, TimeUnit.SECONDS));

        blockingQueue.poll();
        blockingQueue.remove();
        blockingQueue.poll();
        System.out.println(blockingQueue.poll(2,TimeUnit.SECONDS));
    }
}
