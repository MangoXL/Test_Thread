import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

//如果直接使用ArrayList会报错，ConcurrentModificationException异常：并发修改异常或者同时修改异常。
//ArrayList是一个动态数组，初始长度为0，当要使用这个ArrayList时，扩容到10，它的扩容机制是当前长度的0.5加上当前长度
public class NoSafe_ArrayList {
    public static void main(String[] args) {
        //List<Object> list = new ArrayList<>();
        CopyOnWriteArrayList<Object> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 40; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0,4));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}
