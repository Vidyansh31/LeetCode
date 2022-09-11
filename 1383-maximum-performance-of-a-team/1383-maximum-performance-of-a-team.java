class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] arr = new int[n][2];
        
        for(int i = 0; i < n; i++){
            arr[i][0] = speed[i];
            arr[i][1] = efficiency[i];
        }
        
        Arrays.sort(arr, (a,b) -> {
            return b[1] - a[1];
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> {
            return a - b;
        });
        
        long eff = 0, sumS = 0;
        for(int i = 0; i < n; i++){
            pq.add(arr[i][0]);
            sumS += arr[i][0];
            if(pq.size() > k){
                sumS -= pq.remove();
            }
            eff = Math.max(eff, sumS * arr[i][1]);
        }
        
        
        return (int)(eff%(long)1000000007);
    }
}