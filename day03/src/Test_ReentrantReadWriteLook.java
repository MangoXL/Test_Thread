import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 多个线程同时读一个资源类没有问题，所以为了满足并发量，读取共享资源应该同时进行
 * 但是如果有一个线程想去写共享资源，就不应该再有其他线程对该资源进行读或写
 * 小总结：
 *          1、读和读能共存
 *          2、读和写不能共存
 *          3、写和写不能共存
 */
public class Test_ReentrantReadWriteLook {
    public static void main(String[] args) {
        MyCache m = new MyCache();

        for(int i = 1; i <= 5; i++){
            final int temp = i;
            new Thread(() -> {
                m.put(temp + "",temp);
            },String.valueOf(i)).start();
        }

        for(int i = 1; i <= 5; i++){
            final int temp = i;
            new Thread(() -> {
                m.get(temp + "");
            },String.valueOf(i)).start();
        }
    }
}

class MyCache{
    private HashMap<String,Object> map = new HashMap<>();
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public Object put(String key,Object value){
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t正在写");
            map.put(key,value);
            System.out.println(Thread.currentThread().getName() + "\t写完成");
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.writeLock().unlock();
        }
        return map;
    }

    public Object get(String key){
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t正在读");
            map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t读完成");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.readLock().unlock();
        }
        return map;
    }
}
