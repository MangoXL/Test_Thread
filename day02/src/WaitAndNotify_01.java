//题目：现在两个线程，可以操作初始值为零的一个变量，实现一个线程对该变量加1，
// 一个线程对该变量减1，实现交替10轮，变量初始值为零
public class WaitAndNotify_01 {
    public static void main(String[] args) {
        Variate_01 variate = new Variate_01();
        new Thread(() ->{
            for (int i = 1; i <= 10; i++){
                try {
                    variate.addNumber();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(() ->{
            for (int i = 1; i <= 10; i++){
                try {
                    variate.subtractNumber();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
    }
}
class Variate_01 {
    //声明一个变量，初始值0
    private int number = 0;
    //增加方法
    public synchronized void addNumber() throws InterruptedException {
        //判断该线程执行条件是否满足
        if(number % 2 != 0){
            //条件不满足，该线程进入等待状态
            this.wait();
        }
        //具体执行业务
        number++;
        System.out.println(Thread.currentThread().getName() + "\t" + number);
        this.notifyAll();
    }
    //减少方法
    public synchronized void subtractNumber() throws InterruptedException {
        //判断该线程执行条件是否满足
        if(number % 2 == 0){
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
