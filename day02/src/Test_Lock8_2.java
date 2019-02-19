import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

//2 短信暂停4秒钟，请问先打印短信还是邮件？
//先打印短信，原因：当一个线程进入一个synchronized方法，它锁定的是synchronized所在的整个类，而不是该方法
public class Test_Lock8_2 {
    public static void main(String[] args) {
        Phone2 phone = new Phone2();
        new Thread(() -> {
            phone.sendSMS();
        },"B").start();
        try { sleep(200);} catch (InterruptedException e) { e.printStackTrace(); }
        new Thread(() -> {
            phone.sendEmail();
        },"B").start();
    }
}

class Phone2{
        public synchronized void sendSMS(){
            try { TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println("-------sendSMS-------");
        }
        public synchronized void sendEmail(){
            System.out.println("-------sendEmail-------");
        }
}
