class RandomizedSet {
    
    List<Integer> list;
    Map<Integer,Integer> map;
    Random r;
    
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        r = new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        
        map.put(val,list.size());
        list.add(val);
        
        return true;
    }
    
    public void swap(int val1, int idx1,  int idx2){
        int val2 = list.get(idx2);
        
        map.put(val1,idx2);
        map.put(val2, idx1);
        
        list.set(idx1,val2);
        list.set(idx2,val1);
    }
    
    public boolean remove(int val) {
        if(map.containsKey(val) == false){
            return false;
        }
        
        int lval = list.get(list.size() - 1);
        if(val == lval){
            list.remove(list.size()-1);
            map.remove(val);
        }
        else{
            int idx = map.get(val);
            swap(val,idx,list.size()-1);
            list.remove(list.size()-1);
            map.remove(val);
        }
        
        return true;
    }
    
    public int getRandom() {
        int idx = r.nextInt(list.size());
        
        return list.get(idx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */