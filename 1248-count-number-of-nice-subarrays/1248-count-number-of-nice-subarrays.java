class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        
        // HashMap<Integer,Integer> map = new HashMap<>();
        int[] farr = new int[nums.length+1];
        farr[0] = 1;
        // map.put(0,1);
        int count = 0;
        int res = 0;
        for(int num : nums){
            if(num % 2 == 1){
                count++;
            }
            
            // map.put(count, map.getOrDefault(count,0)+1);
            farr[count] += 1;
            // res += map.getOrDefault(count - k, 0);
            if(count - k >= 0){
                res += farr[count-k];
            }
            
        }
        
        return res;
    }
}