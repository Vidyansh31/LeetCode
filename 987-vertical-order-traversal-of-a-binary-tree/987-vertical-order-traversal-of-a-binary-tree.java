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
            if(this.h == o.h ){
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
        
        int minv = 0;
        int maxv = 0;
        
        while(qu.size() > 0){
            Pair rem = qu.remove();
            
            // System.out.println(rem.node.val+" "+rem.h+" "+ rem.v);
            if(map.containsKey(rem.v)){
                map.get(rem.v).add(rem);
            }
            else{
                map.put(rem.v,new PriorityQueue<>());
                map.get(rem.v).add(rem);
            }
            
            minv = Math.min(rem.v,minv);
            maxv = Math.max(rem.v,maxv);
            
            if(rem.node.left != null){
                qu.add(new Pair(rem.node.left,rem.h+1,rem.v-1));
            }
            
            if(rem.node.right != null){
                 qu.add(new Pair(rem.node.right,rem.h+1,rem.v+1));
            }
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = minv; i <= maxv; i++){
            List<Integer> order = new ArrayList<>();
            while(map.get(i).size() > 0){
                order.add(map.get(i).remove().node.val);
            }
            ans.add(order);
        }
        
        return ans;
        
    }
}