class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        parent = new HashMap<>();
        mult = new HashMap<>();
        
        for(List<String> eqn : equations){
            addToDSU(eqn.get(0));
            addToDSU(eqn.get(1));
        }
        
        
        int idx = 0;
        for(List<String> eqn : equations){
            //find lead;
            String l0 = find(eqn.get(0));
            String l1 = find(eqn.get(1));
            
            Double m0 = mult.get(eqn.get(0));
            Double m1 = mult.get(eqn.get(1));
            
            //union
            mult.put(l0, (values[idx]*m1)/m0);
            parent.put(l0,l1);
            
            idx++;
            
        }
        
        double[] res = new double[queries.size()];
        int i = 0;
        for(List<String> query : queries){
            if(parent.containsKey(query.get(0)) == false || parent.containsKey(query.get(1)) == false){
                res[i] = -1;
                i++;
                continue;
            }
            
            String l0 = find(query.get(0));
            String l1 = find(query.get(1));
            
            if(l0.equals(l1) == false){
                res[i] = -1;
                i++;
                continue;
            }
            
            Double m0 = mult.get(query.get(0));
            Double m1 = mult.get(query.get(1));
                
            res[i] = m0/m1;
            i++;
            
        }
        
    
        return res;
    }

    HashMap<String, String> parent;
    HashMap<String,Double> mult;
    
    private void addToDSU(String s){
        if(parent.containsKey(s) == false){
            parent.put(s,s);
            mult.put(s,1.0);
        }
    }
    
    private String find(String x){
        if(parent.get(x).equals(x)){
            return x;
        }
        else {
            String cp = parent.get(x);
            String fp = find(cp);
            
            mult.put(x, mult.get(x) * mult.get(cp));
            parent.put(x,fp);
            
            return fp;
        }
    }
}