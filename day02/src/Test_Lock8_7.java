import java.util.concurrent.TimeUnit;

//7 一个普通同步方法，一个静态同步方法，1部手机，请问先打印短信还是邮件？
//先打印邮件，原因：加锁的对象不是同一个对象，static加锁的是全局锁，锁的是整个类模板，也就是phone.class
// 而普通方法是对象锁，锁的是this当前这个对象
public class Test_Lock8_7 {
    public static void main(String[] args) {
        Phone7 phone = new Phone7();
        new Thread(() -> {
            phone.sendSMS();
        },"A").start();
        try { Thread.sleep(200);} catch (InterruptedException e) { e.printStackTrace(); }
        new Thread(() -> {
            phone.sendEmail();
        },"B").start();
    }
}

class Phone7{
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
