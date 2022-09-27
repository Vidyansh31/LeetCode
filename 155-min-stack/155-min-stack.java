class MinStack {
    Stack<Long> data;
    long min;
    public MinStack() {
        data = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        long val1 = val;
        if(data.size() == 0){
            data.push(val1);
            min = val1;
        }
        else if(min > val1){
            data.push(val1 + val1 - min);
            min = val1;
        }
        else{
            data.push(val1);
        }
    }
    
    public void pop() {
        if(data.peek() < min){
            min = 2*min - data.peek();
        }
        data.pop();
    }
    
    public int top() {
        if(data.peek() < min){
            return (int) min;
        }
        else{
            long ans = data.peek();
            return (int)ans;
        }
    }
    
    public int getMin() {
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */