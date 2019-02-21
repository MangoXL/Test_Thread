import java.util.concurrent.ArrayBlockingQueue;

/**
 * 当阻塞队列满时,如果继续往队列中put元素，队列会一直阻塞，直到put进去数据或者响应中断退出
 * 当阻塞队列空时，如果继续从队列中take元素，队列会一直阻塞，直到队列可用或者响应中断退出
 */
public class Test_BlockingQueue_PutAndTake {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue(3);

        blockingQueue.put("1");
        blockingQueue.put("1");
        blockingQueue.put("1");
        //blockingQueue.put("1");
        System.out.println();

        blockingQueue.take();
        blockingQueue.take();
        blockingQueue.take();
        //blockingQueue.take();
    }
}
