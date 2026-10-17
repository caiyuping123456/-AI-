import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Cache {

    static class Entry {
        Object value;
        long expireAt;
    }

    static Map<String, Entry> map = new HashMap<>();

    static {
        Thread cleaner = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(2000);
                    cleanExpired();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
        cleaner.setDaemon(true);
        cleaner.start();
    }

    public static void put(String key, Object value) {
        Entry e = new Entry();
        e.value = value;
        e.expireAt = Long.MAX_VALUE;
        map.put(key, e);
    }

    public static void put(String key, Object value, long ttlMillis) {
        Entry e = new Entry();
        e.value = value;
        e.expireAt = System.currentTimeMillis() + ttlMillis;
        map.put(key, e);
    }

    public static Object get(String key) {
        Entry e = map.get(key);
        if (e == null) return null;
        if (e.expireAt < System.currentTimeMillis()) {
            map.remove(key);
            return null;
        }
        return e.value;
    }

    public static void remove(String key) {
        map.remove(key);
    }

    public static int size() {
        return map.size();
    }

    public static void cleanExpired() {
        long now = System.currentTimeMillis();
        Iterator<Map.Entry<String, Entry>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Entry> e = it.next();
            if (e.getValue().expireAt < now) {
                it.remove();
            }
        }
    }

    // ===== 测试 =====
    public static void main(String[] args) throws InterruptedException {
        put("a", "hello");
        System.out.println(get("a"));          // hello

        put("b", "world", 1000);
        System.out.println(get("b"));          // world
        Thread.sleep(1500);
        System.out.println(get("b"));          // null

        put("c", "x");
        remove("c");
        System.out.println(get("c"));          // null

        System.out.println("size = " + size()); // 1
    }
}