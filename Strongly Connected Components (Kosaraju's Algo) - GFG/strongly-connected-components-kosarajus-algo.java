// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        //Step 1 : Fill Stack
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[V];
        
        //dfs from all vertex
        for(int i = 0; i < V; i++){
            if(vis[i] == false){
                dfs(i,adj,st,vis);
            }
        }
        
        // System.out.println(st);
        
        
        
        //transpose graph
        ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();
        for(int i = 0; i < V; i++){
            transpose.add(new ArrayList<>());
        }
        for(int i = 0; i < V; i++){
            for(int e : adj.get(i)){
                transpose.get(e).add(i);
            }
        }
        
        //Step 3 : Stack se nikal ke dfs lagana
        boolean[] vis2 = new boolean[V];
        int count = 0;
        while(st.size() > 0){
            int v = st.pop();
            if(vis2[v] == false){
                dfs2(v,transpose,vis2);
                count++;
            }
        }
        return count;
        
    }
    
    public void dfs(int src,ArrayList<ArrayList<Integer>> adj, Stack<Integer> st, boolean[] vis ){
        //mark 
        vis[src] = true;
        
        //call from nbr
        for(int i = 0; i < adj.get(src).size(); i++){
            int nbr = adj.get(src).get(i);
            if(vis[nbr] == false){
                dfs(nbr,adj,st,vis);
                
            }
        }
        
        st.push(src);
    }
    
    public void dfs2(int src,ArrayList<ArrayList<Integer>> adj, boolean[] vis ){
        //mark 
        vis[src] = true;
        
        //call from nbr
        for(int i = 0; i < adj.get(src).size(); i++){
            int nbr = adj.get(src).get(i);
            if(vis[nbr] == false){
                dfs2(nbr,adj,vis);
                
            }
        }
        
    }

}
