class LFUCache {
    
    class Node{
        int val;
        int key;
        int freq;
        Node prev;
        Node next;
        
        Node(int key, int val){
            this.key = key;
            this.val = val;
            this.freq = 1;
        }
    }
    
    class DLL{
        int listsize;
        Node head;
        Node tail;
        
        
        DLL(){
            this.head = new Node(0,0);
            this.tail = new Node(0,0);
            this.listsize = 0;
            
            head.next = tail;
            tail.prev = head;
            
        }
        
        public void addNode(Node curNode) {
            Node nextNode = head.next;
            curNode.next = nextNode;
            curNode.prev = head;
            head.next = curNode;
            nextNode.prev = curNode;
            listsize++;
        }

        /** remove input node and decrease list size by 1**/
        public void removeNode(Node curNode) {
            Node prevNode = curNode.prev;
            Node nextNode = curNode.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            listsize--;
        }

    }
    
    final int cap;
    int currsize ;
    int min ;
    HashMap<Integer,Node> nodemap;
    HashMap<Integer,DLL> listmap;

    public LFUCache(int capacity) {
        nodemap = new HashMap<>();
        listmap = new HashMap<>();
        cap = capacity;
        currsize = 0;
        min = 0;
    }
    
    public int get(int key) {
        Node currNode = nodemap.get(key);
        
        if(currNode == null){
            return -1;
        }
        
        updateNode(currNode);
        
        return currNode.val;
    }
    
    public void put(int key, int value) {
        if(cap == 0){
            return;
        }
        
        if(nodemap.containsKey(key)){
            Node currNode = nodemap.get(key);
            currNode.val = value;
            updateNode(currNode);
        }
        else{
            currsize++;
            
            if(currsize > cap){
                //Get minimum frequnecyList
                DLL minfreqList = listmap.get(min);
                nodemap.remove(minfreqList.tail.prev.key);
               minfreqList.removeNode(minfreqList.tail.prev);
                currsize--;
                
            }
            
             // reset min frequency to 1 because of adding new node
            min = 1;
            Node newNode = new Node(key, value);

            // get the list with frequency 1, and then add new node into the list, as well as into LFU cache
            DLL curList = listmap.getOrDefault(1, new DLL());
            curList.addNode(newNode);
            listmap.put(1, curList);
            nodemap.put(key, newNode);
            
        }
        
    }
    
     public void updateNode(Node curNode) {
        int curFreq = curNode.freq;
        DLL curList = listmap.get(curFreq);
        curList.removeNode(curNode);

        // if current list the the last list which has lowest frequency and current node is the only node in that list
        // we need to remove the entire list and then increase min frequency value by 1
        if (curFreq == min && curList.listsize == 0) {
            min++;
        }

        curNode.freq++;
        // add current node to another list has current frequency + 1,
        // if we do not have the list with this frequency, initialize it
        DLL newList = listmap.getOrDefault(curNode.freq, new DLL());
        newList.addNode(curNode);
        listmap.put(curNode.freq, newList);
    }
    
    
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */