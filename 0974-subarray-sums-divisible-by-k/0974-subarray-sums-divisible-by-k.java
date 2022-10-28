class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        map.put(sum,1);    
        int res = 0;
        for(int num : nums){
            sum += num;
            int rem = sum%k;
            if(rem < 0){
                rem += k;
            }
            res += map.getOrDefault(rem,0);
            
            map.put(rem, map.getOrDefault(rem,0)+1);
        }
        
        return res;
    }
}