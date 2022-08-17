class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> {
            return a[0] - b[0];
        });
        
        int overlap = 0;
        // Stack<int[]> st = new Stack<>();
        // st.push(intervals[0]);
        int end = intervals[0][1];
        
        for(int i = 1; i < intervals.length; i++ ){
            // int[] top = st.pop();
            // int s1 = top[0];
            // int e1 = top[1];
            
            int s2 = intervals[i][0];
            int e2 = intervals[i][1];
            
            if(s2 < end){
                overlap++;
               end = Math.min(end,e2);
            }
            else{
                end = e2;
            }
           
        }
        
        return overlap;
    }
}