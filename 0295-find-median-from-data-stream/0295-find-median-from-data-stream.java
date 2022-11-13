class MedianFinder {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;
    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(left.size() > 0 && num < left.peek()){
            left.add(num);
        }
        else{
            right.add(num);
        }
        
        if(left.size() - right.size() == 2){
            right.add(left.remove());
        }
        else if(right.size() - left.size() == 2){
            left.add(right.remove());
        }
    }
    
    public double findMedian() {
        if(left.size() > right.size()){
            return left.peek();
        }
        else if(left.size() < right.size()){
            return right.peek();
        }
        else{
            return (left.peek() + right.peek())/2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */