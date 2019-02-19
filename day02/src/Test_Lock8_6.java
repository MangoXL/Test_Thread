//6 静态同步方法，2部手机，请问先打印短信还是邮件？
//先打印短信，原因：如果该线程访问的资源方法是static静态方法，因为static是修饰全局对象的，
// 那么加锁的就不是当前类，而是当前实例类的整个类模板，也就是phone.class
//我们称为“全局锁”
public class Test_Lock8_6 {
    public static void main(String[] args) {
        Phone6 phone1 = new Phone6();
        Phone6 phone2 = new Phone6();
        new Thread(() -> {
            phone1.sendSMS();
        },"A").start();
        try { Thread.sleep(200);} catch (InterruptedException e) { e.printStackTrace(); }
        new Thread(() -> {
            phone2.sendEmail();
        },"B").start();
    }
}

class Phone6{
    //发送短信
    public static synchronized void sendSMS(){
        System.out.println("-------sendSMS-------");
    }
    //发送邮件
    public static synchronized void sendEmail(){
        System.out.println("-------sendEmail-------");
    }
}
