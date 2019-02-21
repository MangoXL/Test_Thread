import java.util.HashSet;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 如果直接使用HashSet会出现ConcurrentModificationExpection异常：并发修改或同时修改异常
 * HashSet底层就是一个HashMap，key就是保存的值，value是一个Object类型的常量
 */
public class NoSafe_HashSet {
    public static void main(String[] args) {
       // HashSet<Object> set = new HashSet<>();
        CopyOnWriteArraySet<Object> set = new CopyOnWriteArraySet<>();
        for (int i = 0; i < 30; i++){
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0,4));
                System.out.println(set);
            },String.valueOf(i)).start();
        }
    }
}
