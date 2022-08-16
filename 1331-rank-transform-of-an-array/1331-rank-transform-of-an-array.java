class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] temp = arr.clone();
        Arrays.sort(temp);
        
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.putIfAbsent(temp[i],map.size()+1);
        }
        
        for(int i = 0;i < n; i++){
            arr[i] = map.get(arr[i]);
        }
        
        
        return arr;
    }
}