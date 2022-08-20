class NumArray {
    class Node{
        int st;
        int end;
        Node left;
        Node right;
        int val;
    }
    
    Node root;
    
    Node construct(int[] nums, int lo, int hi){
        if(lo == hi){
            Node base = new Node();
            base.st = base.end = lo;
            base.left = base.right = null;
            base.val = nums[lo];
            return base;
        }
        
        Node node = new Node();
        node.st = lo;
        node.end = hi;
        
        int mid = (lo+hi)/2;
        node.left = construct(nums,lo,mid);
        node.right = construct(nums, mid+1, hi);
        
        node.val += node.left.val + node.right.val;
        
        return node;
    }
    public NumArray(int[] nums) {
        root = construct(nums, 0, nums.length-1);
    }
    
    int query(Node node, int qs, int qe){
        if(qs > node.end || qe < node.st){
            return 0;
        }
        else if(node.st >= qs && node.end <= qe){
            return node.val;
        }
        else{
            int lval = query(node.left,qs,qe);
            int rval = query(node.right,qs,qe);
            
            return lval+rval;
        }
    }
    
    public int sumRange(int left, int right) {
        return query(root, left, right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */