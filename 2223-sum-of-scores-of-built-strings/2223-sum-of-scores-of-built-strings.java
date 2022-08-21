class Solution {
    public long sumScores(String s) {
        int[] z = new int[s.length()];
        z[0] = 0;
        int l = 0;
        int r = 0;
        for(int i = 1; i < s.length(); i++){
            if(i > r){
                l = r = i;
                while(r < s.length() && s.charAt(r) == s.charAt(r-l)){
                    r++;
                }
                r--;
                z[i] = r-l+1;
            }
            else{
                int k = i - l;
                
                if(z[k] < r-i+1){
                    z[i] = z[k];
                }
                else{
                    l = i;
                 while(r < s.length() && s.charAt(r) == s.charAt(r-l)){
                        r++;
                    }
                    r--;
                    z[i] = r-l+1;
                }
            }
        }
        
        long ans = 0;
        for(int val : z){
            ans += val;
        }
        
        return ans+s.length();
    }
}