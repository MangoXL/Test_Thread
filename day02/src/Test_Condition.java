import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//题目：现在四个线程，可以操作初始值为零的一个变量，实现其中两个个线程对该变量加1，
// 两个线程对该变量减1，实现交替10轮，变量初始值为零
//Lock编写
public class Test_Condition {
    public static void main(String[] args) {
        Variate var = new Variate();
        new Thread(() -> {
            for(int i = 1; i <=10 ; i++){
                var.addNumber();
            }
        },"A").start();
        new Thread(() -> {
            for(int i = 1; i <=10 ; i++){
                var.addNumber();
            }
        },"B").start();
        new Thread(() -> {
            for(int i = 1; i <=10 ; i++){
                var.subtractNumber();
            }
        },"C").start();
        new Thread(() -> {
            for(int i = 1; i <=10 ; i++){
                var.subtractNumber();
            }
        },"D").start();
    }
}
class Variate{
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    //增加方法
    public void addNumber()  {
        lock.lock();
        try {
            //判断该线程执行条件是否满足
            while(number % 2 != 0) {
                //条件不满足，该线程进入等待状态
                condition.await();
            }
            //执行具体业务
            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            //通知唤醒其他所有等待中的线程
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    //减少方法
    public void subtractNumber(){
        lock.lock();
        //判断该线程执行条件是否满足
        try {
            while(number % 2 == 0){
                //条件不满足，进入等待状态
                condition.await();
            }
            //执行具体业务
            number--;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            //通知唤醒其他等待中的进程
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
