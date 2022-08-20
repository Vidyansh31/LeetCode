class NumArray {
    class Node{
        int st;
        int se;
        Node left;
        Node right;
        int val;
    }
    
    Node root;
    
    Node construct(int[] nums, int lo, int hi){
        if(lo == hi){
            Node base = new Node();
            base.st = base.se = lo;
            base.left = base.right = null;
            base.val = nums[lo];
            return base;
        }
        
        Node node = new Node();
        node.st = lo;
        node.se = hi;
        
        int mid = (lo+hi)/2;
        
        node.left = construct(nums,lo,mid);
        node.right = construct(nums,mid+1,hi);
        
        node.val += node.left.val + node.right.val;
        
        return node;
    }
    
    public NumArray(int[] nums) {
        root = construct(nums,0,nums.length-1);
    }
    
    void updateVal(Node node, int idx, int val){
        if(node.st == node.se){
            node.val = val;
            return;
        }
        
        int mid = (node.st + node.se)/2;
        if(idx <= mid){
            updateVal(node.left,idx,val);
        }
        else{
            updateVal(node.right,idx,val);
        }
        
        node.val = 0;
        node.val = node.left.val + node.right.val;
    }
    
    public void update(int index, int val) {
        updateVal(root,index,val);
    }
    
    int query(Node node, int qs, int qe){
        if(qs > node.se || qe < node.st){
            return 0;
        }
        else if(node.st >= qs && node.se <= qe){
            return node.val;
        }
        else{
            int lval = query(node.left,qs,qe);
            int rval = query(node.right,qs,qe);
            
            return lval+rval;
        }
    }
    
    public int sumRange(int left, int right) {
        return query(root,left,right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */