class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> qu = new PriorityQueue<>();
        for(int i = 0; i < k ; i++){
            qu.add(nums[i]);
        }
        
        for(int i = k ; i < nums.length; i++){
            if(nums[i] > qu.peek()){
                qu.poll();
                qu.add(nums[i]);
            }
        }
        
        return qu.poll();
    }
}