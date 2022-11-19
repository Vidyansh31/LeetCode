class Solution {
    public int totalFruit(int[] fruits) {
        int i = 0;
        int j = 0;
        
        
        HashMap<Integer,Integer> map = new HashMap<>();
        int res = 0;
        
        while(j < fruits.length){
            map.put(fruits[j], map.getOrDefault(fruits[j],0)+1);
            
            //release
            while(i < j && map.size() > 2){
                map.put(fruits[i], map.getOrDefault(fruits[i],0)-1);
                if(map.get(fruits[i]) == 0){
                    map.remove(fruits[i]);
                }
                i++;
            }
            
            res = Math.max(res,j-i+1);
            j++;
            
        }
        
        return res;
    }
}