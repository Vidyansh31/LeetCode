class Solution {
    public String pushDominoes(String dominoes) {
        dominoes = "L" + dominoes +"R";
        int prev = 0;
        
        char[] arr = dominoes.toCharArray();
        
        for(int i = 1; i < arr.length; i++){
            if(arr[i] == 'L'){
                if(arr[prev] == 'L'){
                    for(int x = prev+1; x < i; x++){
                        arr[x] = 'L';
                    }
                }
                else if(arr[prev] == 'R'){
                    int lo = prev+1;
                    int hi = i-1;
                    while(lo < hi){
                        arr[lo] = 'R';
                        arr[hi] = 'L';
                        lo++;
                        hi--;
                    }
                }
                prev = i;
            }
            else if(arr[i] == 'R'){
                if(arr[prev] == 'L'){
                    // do nothing
                }
                else if(arr[prev] == 'R'){
                    for(int x = prev+1; x < i; x++){
                        arr[x] = 'R';
                    }
                }
                prev = i;
            }
        }
        
        StringBuilder sb = new StringBuilder("");
        
        for(int i = 1; i < arr.length-1; i++){
            sb.append(arr[i]+"");
        }
        
        return sb.toString();
    }
}