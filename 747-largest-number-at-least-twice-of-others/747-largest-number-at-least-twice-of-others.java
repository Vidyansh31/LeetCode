class Solution {
    public int dominantIndex(int[] nums) {
        PriorityQueue<Integer> qu = new PriorityQueue<>((a,b) -> {
            return b-a;
        });
        
        for(int num : nums){
            qu.add(num);
        }
        
        int largest = qu.poll();
        
        if(largest < 2*qu.peek()){
            return -1;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == largest){
                return i;
            }
        }
        
        
        return -1;
        
    }
}