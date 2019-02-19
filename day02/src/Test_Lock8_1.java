/* 题目：多线程8锁
* 1 一般访问，请问先打印短信还是邮件？
* 2 短信暂停4秒钟，请问先打印短信还是邮件？
* 3 新增普通开机方法， 请问先打印短信还是开机？
* 4 有两部手机，请问先打印短信还是邮件？
* 5 静态同步方法，1部手机，请问先打印短信还是邮件？
* 6 静态同步方法，2部手机，请问先打印短信还是邮件？
* 7 一个普通同步方法，一个静态同步方法，1部手机，请问先打印短信还是邮件？
* 8 一个普通同步方法，一个静态同步方法，2部手机，请问先打印短信还是邮件？*/
//随机打印，由CUP调度
public class Test_Lock8_1 {
    public static void main(String[] args) {
        Phone1 phone = new Phone1();
        new Thread(() -> {
            phone.sendSMS();
        },"A").start();
        try { Thread.sleep(200);} catch (InterruptedException e) { e.printStackTrace(); }
        new Thread(() -> {
            phone.sendEmail();
        },"B").start();
    }
}
class Phone1{
    //发送短信
    public synchronized void sendSMS(){
        System.out.println("-------sendSMS-------");
    }
    //发送邮件
    public synchronized void sendEmail(){
        System.out.println("-------sendEmail-------");
    }
}
