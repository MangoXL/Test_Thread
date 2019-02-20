import java.util.concurrent.CountDownLatch;

public class Test_CountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for(int i = 1; i <= 6; i++){
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "度过了！");
                countDownLatch.countDown();
            },Week_Enum.for_Week(i).getMessage()).start();
        }
        countDownLatch.await();
        System.out.println("周日放假咯！！！");
    }
}
