class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) ->  b-a);
        
        for(int values : map.values()){
            pq.add(values);
        }
        
        int sum = 0;
        int count = 0;
        
        while(sum < arr.length/2){
            sum += pq.remove();
            count++;
        }
        
        return count;
    }
}