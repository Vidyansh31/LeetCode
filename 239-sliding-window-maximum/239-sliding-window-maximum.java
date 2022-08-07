class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] nge = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        st.push(nums.length-1);
        nge[nums.length-1] = nums.length;
        for(int i = nums.length-2; i>= 0; i--){
            while(st.size() > 0 && nums[i] > nums[st.peek()]){
                st.pop();
            }
            
            if(st.size() == 0){
                nge[i] = nums.length;
            }
            else{
                nge[i] = st.peek();
            }
            
            st.push(i);
        }
        
        int[] res = new int[nums.length-k+1];
        int j = 0;
        
        for(int i = 0; i < res.length; i++){
            if(j < i){
                j++;
            }
            while(nge[j] <= i + k -1){
                j = nge[j];
            }
            
            res[i] = nums[j];
        }
        
        return res;
    }
}