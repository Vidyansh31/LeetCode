class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int st = 0;
        int end = 0;
        int runningSum = 0;
        int maxSum = 0;
        Set<Integer> set = new HashSet<>();
        
        while(end < nums.length){
            int currEle = nums[end];
            if(!set.contains(currEle)){
                set.add(currEle);
                runningSum += currEle;
                maxSum = Math.max(runningSum,maxSum);
                end++;
            }else{
                int deleteEle = nums[st];
                set.remove(deleteEle);
                runningSum -= deleteEle;
                st++;
            }
        }
        
        return maxSum;
        
        
    }
}