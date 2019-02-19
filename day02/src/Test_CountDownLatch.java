import java.util.concurrent.CountDownLatch;

public class Test_CountDownLatch {
    public static void main(String[] args) throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for(int i = 1; i <= 6; i++){
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "灭亡！");
                countDownLatch.countDown();
            },CountDownEnum.for_CountDownEnum(i).getMessage()).start();
        }
        countDownLatch.await();
        System.out.println("秦国统一六国！");
    }

    public static void colseDoor() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for(int i = 1; i <= 6; i++){
            final int temp = i;
            new Thread(() -> {
                System.out.println(temp + "\t离开教室");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println("关门！");
    }
}

