class Solution {
    public int[][] reconstructQueue(int[][] people) {
        //sort in reverse order
        Arrays.sort(people, (a,b) -> a[0] == b[0] ? a[1]-b[1] : b[0] - a[0]);
        
        List<int[]> rl = new ArrayList<>();
        for(int[] p : people){
            rl.add(p[1],p);
        }
        
        return rl.toArray(new int[rl.size()][]);
    }
}