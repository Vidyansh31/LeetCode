class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums,k) - atMost(nums,k-1);
    }
    
    int atMost(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        int j = -1;
        int res = 0;
        
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
            
            //release
            while(j < i && map.size() > k){
                j++;
                if(map.get(nums[j]) == 1){
                    map.remove(nums[j]);
                }
                else{
                    map.put(nums[j],map.get(nums[j])-1);
                }
            }
            
            res += (i-j);
        }
        
        return res;
    }
}