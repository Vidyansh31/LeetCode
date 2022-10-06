class TimeMap {
    class Pair{
        int time;
        String val;
        
        Pair(int time, String val){
            this.time = time;
            this.val = val;
        }
    }
    
    Map<String,ArrayList<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key) == false){
            map.put(key,new ArrayList<>());
        }
        map.get(key).add(new Pair(timestamp,value));
    }
    
    public String get(String key, int timestamp) {
        if(map.containsKey(key) == false){
            return "";
        }
        else{
            List<Pair> list = map.get(key);
            int lo = 0;
            int hi = list.size() - 1;
            
            while(lo <= hi){
                int mid = (lo+hi)/2;
                Pair m = list.get(mid);
                
                if(m.time == timestamp){
                    return m.val;
                }
                else if(m.time > timestamp){
                    hi = mid - 1;
                }
                else{
                    if(mid == hi || list.get(mid+1).time > timestamp){
                        return  list.get(mid).val;
                    }
                    lo = mid+1;
                }
            }
            return "";
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */