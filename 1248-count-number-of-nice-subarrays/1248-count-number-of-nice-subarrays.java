class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int count = 0;
        int res = 0;
        for(int num : nums){
            if(num % 2 == 1){
                count++;
            }
            
            map.put(count, map.getOrDefault(count,0)+1);
            res += map.getOrDefault(count - k, 0);
            
        }
        
        return res;
    }
}