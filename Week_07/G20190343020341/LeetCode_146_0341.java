import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LeetCode_146_0341 {
}

class LRUCache {
    LinkedList list = new LinkedList();
    HashMap<Integer, Integer> map;
    private int capacity = 0;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        int value = map.get(key);
        list.remove((Integer)key);
        list.addFirst(key);
        return value;
    }

    public void put(int key, int value) {
        if(!map.containsKey(key)) {
            if(cacheFull()) {
                int oldKey = (int)list.removeLast();
                map.remove(oldKey);
            }
            list.addFirst(key);
            map.put(key, value);
        } else {
            list.remove((Integer) key);
            list.addFirst(key);
            map.put(key, value);
        }
    }

    public boolean cacheFull() {
        return list.size() + 1 > capacity ? true : false;
    }
}
