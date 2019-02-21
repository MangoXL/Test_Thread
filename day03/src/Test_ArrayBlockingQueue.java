import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 当阻塞队列满时，再往队列中插入元素add回抛异常：java.lang.IllegalStateException: Queue full
 * 当阻塞队列空时，再从队列中移除元素remove会抛异常：java.util.NoSuchElementException
 */
public class Test_ArrayBlockingQueue {
    public static void main(String[] args) {
        BlockingQueue blockingQueue = new ArrayBlockingQueue(3);
        //往阻塞队列中添加元素：add()
        System.out.println(blockingQueue.add(1));
        System.out.println(blockingQueue.add(2));
        System.out.println(blockingQueue.add(3));

        //System.out.println(blockingQueue.add(4));

        System.out.println();

        //查看阻塞队列中第一个元素：element()
        System.out.println(blockingQueue.element());

        //移除阻塞队列中的元素：remove()
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        //System.out.println(blockingQueue.remove());

    }
}
