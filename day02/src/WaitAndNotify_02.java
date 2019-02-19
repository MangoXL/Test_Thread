//题目：现在四个线程，可以操作初始值为零的一个变量，实现其中两个个线程对该变量加1，
// 两个线程对该变量减1，实现交替10轮，变量初始值为零
public class WaitAndNotify_02 {
    public static void main(String[] args) {
        Variate_02 var = new Variate_02();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    var.addNumber();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++){
                try {
                    var.addNumber();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
        new Thread(() -> {
            for(int i = 1; i <= 10; i++){
                try {
                    var.subtractNumber();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++){
                try {
                    var.subtractNumber();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D").start();
    }
}
class Variate_02{
    private int number = 0;
    //增加方法
    public synchronized void addNumber() throws InterruptedException {
        //判断该线程执行条件是否满足
        while(number % 2 != 0){
            //条件不满足，该线程进入等待状态
            this.wait();
        }
        //具体执行业务
        number++;
        System.out.println(Thread.currentThread().getName() + "\t" + number);
        //通知唤醒其他所有等待中的进程
        this.notifyAll();
    }
    //减少方法
    public synchronized void subtractNumber() throws InterruptedException {
        //判断该线程执行条件是否满足
        while(number % 2 == 0){
            //条件不满足，该线程进入等待状态
            this.wait();
        }
        //具体执行业务
        number--;
        System.out.println(Thread.currentThread().getName() + "\t" + number);
        //通知唤醒其他所有等待中的进程
        this.notifyAll();
    }
}
