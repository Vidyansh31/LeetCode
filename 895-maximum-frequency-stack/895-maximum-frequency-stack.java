class FreqStack {
    Map<Integer,Integer> freq;
    Map<Integer,Stack<Integer>> stmap;
    int maxFreq;
    public FreqStack() {
        freq = new HashMap<>();
        stmap  = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        
            freq.put(val,freq.getOrDefault(val,0)+1);
            maxFreq = Math.max(freq.get(val),maxFreq);
            
            if(stmap.containsKey(freq.get(val))){
                stmap.get(freq.get(val)).push(val);
            }
            else{
                stmap.put(freq.get(val),new Stack<>());
                stmap.get(freq.get(val)).push(val);
            }
        
    }
    
    public int pop() {
        int ans = stmap.get(maxFreq).pop();
        if(stmap.get(maxFreq).size() == 0){
            maxFreq--;
        }
        freq.put(ans, freq.get(ans)-1);
        return ans;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */