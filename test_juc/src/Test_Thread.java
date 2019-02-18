import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test_Thread {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        System.out.println("111");
        new Thread(() -> {for (int i = 0; i < 40; i++) ticket.sell();},"A").start();
        new Thread(() -> {for (int i = 0; i < 40; i++) ticket.sell();},"B").start();
        new Thread(() -> {for (int i = 0; i < 40; i++) ticket.sell();},"C").start();
    }
}
class Ticket{
    private int number = 30;
    private Lock lock = new ReentrantLock();
    public void sell(){
            lock.lock();
        try {
            if(number > 0){
                System.out.println(Thread.currentThread().getName() + "\t当前正在售卖第" + number + "票\t剩余" + --number + "张票");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
}
