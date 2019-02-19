import java.util.concurrent.TimeUnit;

//8 一个普通同步方法，一个静态同步方法，2部手机，请问先打印短信还是邮件？
//先打印邮件，原因：加锁的对象不是同一个对象，static加锁的是全局锁，锁的是整个类模板，也就是phone.class
// 而普通方法是对象锁，锁的是this当前这个对象，并且也是两个实例对象，互不共享资源，不会受到影响
public class Test_Lock8_8 {
    public static void main(String[] args) {
        Phone8 phone1 = new Phone8();
        Phone8 phone2 = new Phone8();
        new Thread(() -> {
            phone1.sendSMS();
        },"A").start();
        try { Thread.sleep(200);} catch (InterruptedException e) { e.printStackTrace(); }
        new Thread(() -> {
            phone2.sendEmail();
        },"B").start();
    }
}

class Phone8{
    //发送短信
    public static synchronized void sendSMS(){
        try { TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("-------sendSMS-------");
    }
    //发送邮件
    public synchronized void sendEmail(){
        System.out.println("-------sendEmail-------");
    }
}
