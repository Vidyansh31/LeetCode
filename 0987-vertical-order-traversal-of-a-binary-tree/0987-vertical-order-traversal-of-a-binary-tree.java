/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public class Pair implements Comparable<Pair>{
        TreeNode node;
        int h;
        int v;
        
        Pair(TreeNode node, int h, int v){
            this.node = node;
            this.h = h;
            this.v = v;
        }
        
        public int compareTo(Pair o){
            if(this.h == o.h){
                return this.node.val - o.node.val;
            }
            else{
                return this.h - o.h;
            }
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer,PriorityQueue<Pair>> map = new HashMap<>();
        
        Queue<Pair> qu = new LinkedList<>();
        qu.add(new Pair(root,0,0));
        
        int lv = 0;
        int rv = 0;
        
        while(qu.size() > 0){
            Pair rem = qu.remove();
            
            if(rem.v < lv){
                lv = rem.v;
            }
            
            if(rem.v > rv){
                rv = rem.v;
            }
            
            if(map.containsKey(rem.v) == false){
                map.put(rem.v, new PriorityQueue<>());
                map.get(rem.v).add(rem);
            }
            else{
                map.get(rem.v).add(rem);
                
            }
            
            if(rem.node.left != null ){
                qu.add(new Pair(rem.node.left,rem.h+1,rem.v-1));
            }
            
            
             if(rem.node.right != null ){
                qu.add(new Pair(rem.node.right,rem.h+1,rem.v+1));
            }
        }
        
        
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i = lv; i <= rv; i++){
            PriorityQueue<Pair> pq = map.get(i);
            List<Integer> list = new ArrayList<>();
            
            while(pq.size() > 0){
                Pair rem = pq.remove();
                list.add(rem.node.val);
            }
            
            res.add(list);
        }
        
        return res;
    }
}