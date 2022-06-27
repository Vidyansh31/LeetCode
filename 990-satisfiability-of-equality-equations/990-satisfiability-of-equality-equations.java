class Solution {
    public boolean equationsPossible(String[] equations) {
        parent = new int[26];
        rank = new int[26];
        
        for(int i = 0; i < 26; i++){
            parent[i] = i;
            rank[i] = 0;
        }
        
        for(String equation : equations){
            if(equation.charAt(1) == '='){
                int op1 = equation.charAt(0) - 'a';
                int op2 = equation.charAt(3) - 'a';
                
                int l1 = find(op1);
                int l2 = find(op2);
                
                if(l1 != l2){
                    union(l1,l2);
                }
            }
        }
        
         for(String equation : equations){
            if(equation.charAt(1) == '!'){
                int op1 = equation.charAt(0) - 'a';
                int op2 = equation.charAt(3) - 'a';
                
                int l1 = find(op1);
                int l2 = find(op2);
                
                if(l1 == l2){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    int[] rank;
    int[] parent;
    
    int find(int x){
        if(parent[x] == x){
            return x;
        }
        else {
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }
    
    void union(int s1, int s2){
        if(rank[s1] > rank[s2]){
            parent[s2] = s1;
        }
        else  if(rank[s1] < rank[s2]){
            parent[s1] = s2;
        }
        else{
            parent[s1] = s2;
            rank[s1]++;
        }
    }
}