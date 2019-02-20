import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * 线程通信：
 * 1、wait()
 * 2、notify()
 * 3、notifyAll()
 *
 * 两个线程交替打印1-100
 * 线程通信使用的前提，必须在同步方法会同步代码块中使用如上的三个方法
 */
public class Communication {
    public static void main(String[] args) {
        MyThread m = new MyThread();
        new Thread(() -> {
            m.add();
        },"A").start();
        new Thread(() -> {
            m.add();
        },"B").start();
    }
}
class MyThread {
    private int num = 0;
    public void add() {
        while(true){
            synchronized(this){
                notify();
                if(num <= 100){
                    try { Thread.sleep(50);} catch (InterruptedException e) { e.printStackTrace(); }
                    System.out.println(Thread.currentThread().getName() + "\t" + num++);
                }else{
                    break;
                }
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
