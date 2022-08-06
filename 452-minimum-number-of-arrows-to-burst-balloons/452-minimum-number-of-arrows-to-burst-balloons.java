class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b) -> {
            if(a[0] > b[0]){
                return 1;
            }
            else if(a[0] == b[0]){
                return 0;
            }
            else {
                return -1;
            }
        });
        
       
        ArrayList<int[]> list = new ArrayList<>();
        
        for(int[] point : points){
            if(list.size() == 0){
                list.add(point);
            }
            else{
                int[] p = list.get(list.size()-1);
                if(point[0] <= p[1]){
                    p[1] = Math.min(p[1],point[1]);
                }
                else{
                    list.add(point);
                }
            }
        }
        
        
        return list.size();
        
    }
}