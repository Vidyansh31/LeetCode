//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    int arr[] = new int[n];
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    int k = Integer.parseInt(br.readLine().trim());
		    
		    Solution ob= new Solution();
		    System.out.println(ob.countKdivPairs(arr, n, k));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static long countKdivPairs(int arr[], int n, int k)
    {
        //code here
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : arr){
            int rem = num%k;
            if(rem < 0){
                rem += k;
            }
            
            map.put(rem , map.getOrDefault(rem,0)+1);
        }
        
        int left = 1;
        int right = k-1;
        
        long res =0;
        while(left < right){
            res += map.getOrDefault(left,0) * map.getOrDefault(right,0);
            left++;
            right--;
        }
        
        int freq = map.getOrDefault(0,0);
        res += (freq * (freq-1) / 2);
        
        if(k%2 == 0){
            freq = map.getOrDefault(k/2,0);
          res += (freq * (freq-1) / 2);
        }
        return res;
    }
}