class Solution {
    
    public int majorityElement(int[] nums) {
        int floor = (int)Math.floor(nums.length/2);
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums){
            if(map.containsKey(num)){
                map.put(num , map.get(num)+1);
            }
            else{
                map.put(num,1);
            }
        }
        
         
       for(Map.Entry<Integer, Integer> entry : map.entrySet()){
           if(entry.getValue() > floor){
               return entry.getKey();
           }
       }
        
        return 0;
        
        
        
    }
}