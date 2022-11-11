//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            long N=sc.nextLong();
			
            Solution ob = new Solution();
            ArrayList<Long> ans = ob.factorialNumbers(N);
            for(long num : ans){
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static ArrayList<Long> factorialNumbers(long N){
        // code here
        ArrayList<Long> list = new ArrayList<>();
        list.add(1L);
        if(N == 1){
            return list;
        }
        
        helper(2,N,list);
        
        return list;
    }
    
    static void helper(long st, long end, ArrayList<Long> list){
        int size = list.size();
        if(list.get(size - 1) > end){
            list.remove(size - 1);
            return;
        }
        
        long num = list.get(size - 1) * st;
        list.add(num);
        
        helper(st+1,end,list);
    }
}