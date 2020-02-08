class Node{//定义节点类
    public int key, value;
    public Node prev, next;
    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}

class DoubleLink{//定义双向链表
    private Node head,tail;  //内置头尾节点便于操作
    private int size;

    public DoubleLink(){
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    //添加只会在头部进行添加，而删除可以是任何位置
    public void addFirst(Node x){
        x.prev = head;
        x.next = head.next;
        head.next.prev = x;
        head.next = x;
        size++;
    }

    public void remove(Node x){
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size--;
    }

    public Node removeLast(){
        if(tail.prev == head) return null;
        Node last = tail.prev;
        remove(last);
        return last;
    }

    public int size(){
        return size;
    }
}

class LRUCache {
    private DoubleLink dl;
    private HashMap<Integer,Node> hashmap; 
    private int size;

    public LRUCache(int capacity) {
        size = capacity;
        dl = new DoubleLink();
        hashmap = new HashMap<>();
    }
    
    public int get(int key) {
        if(!hashmap.containsKey(key)){
            return -1;
        }else{
            int value = hashmap.get(key).value;
            put(key,value);  //通过put函数来实现更新
            return value;
        }
    }
    
    public void put(int key, int value) {
        Node x = new Node(key,value);
        if(hashmap.containsKey(key)){
            //如果key已经包含，更新value，并且将Node提前
            dl.remove(hashmap.get(key));
            // dl.addFirst(x);
            // hashmap.put(key,x);
        }else{
            if(size == dl.size()){
                //缓存空间已满，先删除末尾,同步操作HashMap
                Node last = dl.removeLast();
                hashmap.remove(last.key);
            }
            // dl.addFirst(x);
            // hashmap.put(key,x);
        }
        dl.addFirst(x);
        hashmap.put(key,x);
    }
}



/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */