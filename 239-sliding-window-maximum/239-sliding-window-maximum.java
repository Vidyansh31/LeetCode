class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        
        while(j < n){
            while(list.size() > 0 && list.get(list.size()-1) < nums[j]){
                    list.remove(list.size()-1);
                }
                
            list.add(nums[j]);
            if(j - i + 1 < k){
                j++;
            }
            else if(j - i + 1 == k){
                ans[i] = list.get(0);
                if(nums[i] == list.get(0)){
                    list.remove(0);
                }
                i++;
                j++;
            }
        }
        
        return ans;
    }
}