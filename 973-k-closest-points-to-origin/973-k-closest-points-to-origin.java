class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) ->{
            int dist1 =(int)( Math.pow(a[0],2)+Math.pow(a[1],2));
            int dist2 = (int)(Math.pow(b[0],2)+Math.pow(b[1],2));
            
            return dist2 - dist1;
        });
        
        for(int[] point : points){
            pq.add(point);
            
            if(pq.size() > k){
                pq.remove();
            }
        }
        
        
        
        int[][] res = new int[k][2];
        int i = 0;
        while(k-- > 0){
            res[i++] = pq.remove();
        }
        
        return res;
            
    }
}