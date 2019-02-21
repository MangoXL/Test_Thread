import java.util.concurrent.LinkedBlockingQueue;

/**
 * 当阻塞队列满时，继续插入返回值为false
 * 当阻塞队列空时，继续移除返回值为null
 */
public class Test_LinkedBlockingQueue {
    public static void main(String[] args) {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(3);
        //往阻塞队列中添加元素：offer(e)
        System.out.println(linkedBlockingQueue.offer("1"));
        System.out.println(linkedBlockingQueue.offer("2"));
        System.out.println(linkedBlockingQueue.offer("3"));
        System.out.println(linkedBlockingQueue.offer("4"));

        System.out.println();
        //查看阻塞队列中第一个元素：peek()
        System.out.println(linkedBlockingQueue.peek());

        //移除阻塞队列中的元素：poll()
        System.out.println(linkedBlockingQueue.poll());
        System.out.println(linkedBlockingQueue.poll());
        System.out.println(linkedBlockingQueue.poll());
        System.out.println(linkedBlockingQueue.poll());
    }
}
