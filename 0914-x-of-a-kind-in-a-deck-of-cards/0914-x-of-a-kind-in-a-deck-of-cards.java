class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for(int card : deck){
            map.put(card, map.getOrDefault(card,0)+1);
            max = map.get(card);
        }
        
        int ans = 0;
        
        for(int key : map.keySet()){
            int val = map.get(key);
            ans = gcd(ans,val);
        }
        
        return ans > 1;
    }
    
    public int gcd(int a , int b){
        if(a%b==0){
            return b;
        }
        else{
            return gcd(b, a%b);
        }
    }
}