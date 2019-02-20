/**
 * 死锁：不同线程同时分别占用对方需要的同步资源不放弃，都在等待对方放弃自己所需要的同步资源，就形成了线程的死锁
 */
public class Test_DeadLock {
    public static void main(String[] args) {
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();
        new Thread(() -> {
            synchronized(s1){
                s1.append(1);
                s2.append("a");
                try { Thread.sleep(200);} catch (InterruptedException e) { e.printStackTrace(); }
                synchronized(s2){
                    s1.append(2);
                    s2.append("b");
                    System.out.println(Thread.currentThread().getName() + "\t" + s1);
                    System.out.println(Thread.currentThread().getName() + "\t" + s2);
                }
            }
        },"A").start();
        new Thread(() -> {
            synchronized(s2){
                s1.append(3);
                s2.append("c");
                try { Thread.sleep(200);} catch (InterruptedException e) { e.printStackTrace(); }
                synchronized(s1){
                    s1.append(4);
                    s2.append("d");
                    System.out.println(Thread.currentThread().getName() + "\t" + s1);
                    System.out.println(Thread.currentThread().getName() + "\t" + s2);
                }
            }
        },"A").start();
    }
}
