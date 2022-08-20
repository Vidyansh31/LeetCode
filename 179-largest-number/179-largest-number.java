class Solution {
    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        
        for(int i = 0; i < nums.length; i++){
            arr[i] = nums[i]+"";
        }
        
        Arrays.sort(arr, (a,b) -> {
            String case1 = a+b;
            String case2 = b+a;
            return case2.compareTo(case1);
        });
        
        if(arr[0].equals("0")){
            return "0";
        }
        
        StringBuilder sb = new StringBuilder("");
        for(String res : arr){
            sb.append(res);
        }
        
        return sb.toString();
    }
}