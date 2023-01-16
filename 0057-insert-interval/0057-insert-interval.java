class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> res = new ArrayList<>();
        
        int i = 0;
        while(i < intervals.length && intervals[i][1] < newInterval[0]){
            res.add(intervals[i]);
            i++;
        }
        
        int[] interval = newInterval;
        while(i < intervals.length && interval[1] >= intervals[i][0]){
            interval[0] = Math.min(interval[0], intervals[i][0]);
            interval[1] = Math.max(interval[1], intervals[i][1]);
            i++;
        }
        
        res.add(interval);
        
        while(i < intervals.length){
            res.add(intervals[i]);
            i++;
        }
        
        return res.toArray(new int[res.size()][2]);
    }
}