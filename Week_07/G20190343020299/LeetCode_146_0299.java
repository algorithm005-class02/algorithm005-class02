public class LeetCode_146_0299 {

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);

        cache.get(1);

        cache.put(3, 3);

        cache.forEach((k, v) -> {
            System.out.println(String.format("key=%s value=%s", k, v));
        });
    }
}
