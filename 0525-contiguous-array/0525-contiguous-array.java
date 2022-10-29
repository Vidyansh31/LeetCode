class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        map.put(sum,-1);
        
        int res = 0;
        int count = 0;
      for(int i = 0; i < nums.length; i++){
          sum += nums[i] == 0 ? -1 : 1;
          
          if(map.containsKey(sum)){
              res = Math.max(res, i - map.get(sum));
          }
          else{
              map.put(sum, i);
          }
      }
        
        return res;
    }
}