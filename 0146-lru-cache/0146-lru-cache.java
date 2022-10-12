class LRUCache {
    class Node{
        int val;
        int key;
        Node prev;
        Node next;
        
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    
    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    
    Map<Integer,Node> map ;
    int cap;

    public LRUCache(int capacity) {
        cap = capacity;
        map = new HashMap<>();
        
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            insert(node);
            
            return node.val;
        }
        
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        else if(map.size() == cap){
            remove(tail.prev);
        }
        
        insert(new Node(key,value));
    }
    
    public void insert(Node node){
        map.put(node.key,node);
        
        Node headNext = head.next;
        head.next = node;
        headNext.prev = node;
        
        node.next = headNext;
        node.prev = head;
    }
    
    public void remove(Node node){
        int key = node.key;
        map.remove(key);
        
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */