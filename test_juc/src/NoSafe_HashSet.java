import java.util.HashSet;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

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
