class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer,Integer> map = new TreeMap<>(Collections.reverseOrder());
        for(int i = 0; i < speed.length; i++){
            map.put(position[i],speed[i]);
        }
        
        double time = 0;
        int res = 0;
        for(Map.Entry<Integer, Integer> car : map.entrySet()){
            int pos = car.getKey();
            int sp = car.getValue();
            
            int dist = target - pos;
            
            double ctime = dist * 1.0 / sp;
            
            if(ctime > time){
                time = ctime;
                res++;
            }
        }
        
        return res;
    }
}