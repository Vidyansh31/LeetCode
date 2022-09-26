class Solution {
    public int sumSubarrayMins(int[] nums) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        long res = 0;
        long mod = 1000000007;
        for(int i = 0; i < nums.length; i++){
            while(st.size() > 1 && nums[st.peek()] > nums[i]){
                int eleIdx = st.pop();
                int ele = nums[eleIdx];
                
                res += ((long) ele * (eleIdx - st.peek()) * (i - eleIdx))%mod;
                res = res % mod;
            }
            st.push(i);
        }
        
        int rightBoundary = nums.length;
        while(st.size() > 1){
            int eleIdx = st.pop();
            int ele = nums[eleIdx];
                
                res += ((long) ele * (eleIdx - st.peek()) * (rightBoundary - eleIdx))%mod;
                res = res% mod;
        }
        
        return (int)res;
    }
}