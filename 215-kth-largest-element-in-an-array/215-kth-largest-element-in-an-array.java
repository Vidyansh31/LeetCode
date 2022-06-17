class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Simply sort the array and return the nums.length-k element
        // Arrays.sort(nums);
        // return nums[nums.length-k];
        
        PriorityQueue<Integer> qu = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < nums.length; i++){
            qu.add(nums[i]);
        }
        
        int i = 1;
        while(qu.size() > 0){
            if(i == k){
                return qu.poll();
            }
            i++;
            qu.poll();
        }
        
        return -1;
    }
}