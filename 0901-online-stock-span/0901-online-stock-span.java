class StockSpanner {
    int i ;
    Stack<Integer> st;
    int[] arr;
    public StockSpanner() {
        i = 0;
        st = new Stack<>();
        arr = new int[100001];
        st.push(-1);
    }
    
    public int next(int price) {
        int val = 1;
        arr[i] = price;
        
        while(st.size() > 1 && arr[st.peek()] <= arr[i] ){
            st.pop();
        }
        
        val = i - st.peek();
        
        st.push(i);
        i++;
        return val;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */