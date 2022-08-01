class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        
        List<Integer> list = new ArrayList<>(map.keySet());
        
        Collections.sort(list,(a,b) -> {
            return (map.get(a) == map.get(b)? b-a: map.get(a) - map.get(b));
        });
        
        
        int[] res = new int[nums.length];
        int i = 0;
        for(int num : list){
            int count = map.get(num);
            while(count-- > 0){
                res[i++] = num;
            }
        }
        
        return res;
        
    }
}