class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> {
            return a[0] - b[0];
        });
        
        int overlap = 0;
        Stack<int[]> st = new Stack<>();
        st.push(intervals[0]);
        
        for(int i = 1; i < intervals.length; i++ ){
            int[] top = st.pop();
            int s1 = top[0];
            int e1 = top[1];
            
            int s2 = intervals[i][0];
            int e2 = intervals[i][1];
            
            if(s2 < e1){
                overlap++;
                st.push(new int[]{s1,Math.min(e1,e2)});
            }
            else{
                st.push(top);
                st.push(intervals[i]);
            }
        }
        
        return overlap;
    }
}