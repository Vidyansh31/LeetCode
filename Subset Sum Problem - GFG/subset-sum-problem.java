// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{


    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        Boolean[][] dp = new Boolean[N][sum+1];
        return helper(arr,N-1,sum,dp);
    }
    
    private static boolean helper(int[] arr, int idx, int sum,Boolean[][] dp){
        if(sum == 0){
            return true;
        }
        
        if(idx == 0){
            return arr[idx] == sum;
        }
        
        if(dp[idx][sum] != null){
            return dp[idx][sum];
        }
        
        boolean NotPick = helper(arr,idx-1,sum,dp);
        boolean pick = false;
        
        if(arr[idx] <= sum ){
            pick = helper(arr,idx-1,sum-arr[idx],dp);
        }
        
        return dp[idx][sum] = pick || NotPick;
    }
}