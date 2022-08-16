class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] map = new int[1001];
        int max = 0;
        //put all values in arr1 with thier frequency in a hashmap
        for(int num : arr1){
            map[num]++;
            max = Math.max(max,num);
        }
        
        //now loop over arr2 and add element in ans which are present in arr1 
        int[] res = new int[arr1.length];
        int idx = 0;
        for(int i = 0; i < arr2.length; i++){
            int count = map[arr2[i]];
            while(count-- > 0){
                res[idx++] = arr2[i];
                map[arr2[i]]--;
            }
        }
        
        //Now loop over map and add all values which have frequency greater than 0
        for(int i = 0; i <= max; i++){
            while(map[i]-- > 0){
                res[idx++] = i;
            }
        }
        
        return res;
        
    }
}