class Solution {
    public boolean isPossible(int[] target) {
        if(target.length == 1)
            return target[0] == 1;
        
        PriorityQueue<Integer> qu = new PriorityQueue<>(Collections.reverseOrder());
        int sum = 0;
        
        for(int num : target){
            qu.add(num);
            sum += num;
        }
        
        while(qu.peek() != 1){
            int curr = qu.poll();
            
            if(sum - curr == 1){
                return true;
            } 
            
            int x = curr % (sum - curr);
            sum = sum - curr + x;
            
            if(x == 0 || x == curr){
                return false;
            }
            else{
                qu.add(x);
            }
        }
        
        return true;
        
    }
}