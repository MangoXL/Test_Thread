import java.util.concurrent.TimeUnit;

//4 有两部手机，请问先打印短信还是邮件？
//先打印邮件，原因：多个资源不共享，一个线程访问一个资源时加锁，并不会影响其他线程访问其他资源
public class Test_Lock8_4 {
    public static void main(String[] args) {
        Phone4 phone1 = new Phone4();
        Phone4 phone2 = new Phone4();
        new Thread(() -> {
            phone1.sendSMS();
        },"A").start();
        try { Thread.sleep(200);} catch (InterruptedException e) { e.printStackTrace(); }
        new Thread(() -> {
            phone2.sendEmail();
        },"B").start();
    }
}
class Phone4{
    public synchronized void sendSMS(){
        try { TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("-------sendSMS-------");
    }
    public synchronized void sendEmail(){
        System.out.println("-------sendEmail-------");
    }
}

