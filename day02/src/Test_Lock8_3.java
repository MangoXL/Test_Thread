import java.util.concurrent.TimeUnit;

//3 新增普通开机方法， 请问先打印短信还是开机？
//先打印开机，原因：开机是一个普通方法，和标注了synchronized的方法是两个概念，不受锁的影响
public class Test_Lock8_3 {
    public static void main(String[] args) {
        Phone3 phone = new Phone3();
        new Thread(() -> {
            phone.sendSMS();
        },"A").start();
        try { Thread.sleep(200);} catch (InterruptedException e) { e.printStackTrace(); }
        new Thread(() -> {
            phone.openPhone();
        },"B").start();
    }
}
class Phone3{
    //发送短信
    public synchronized void sendSMS(){
        try { TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("-------sendSMS-------");
    }
    //发送邮件
    public synchronized void sendEmail(){
        System.out.println("-------sendEmail-------");
    }
    //开机
    public void openPhone(){
        System.out.println("-------openPhone-------");
    }
}
