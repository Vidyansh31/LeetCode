//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java



import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java



class Solution
{
    boolean checkIsAP(int arr[] ,int n)
    {
        // code here
        HashSet<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int smin = Integer.MAX_VALUE;
        
        for(int num : arr){
            if(set.contains(num)){
                return false;
            }
            set.add(num);
            
            if(num <= min){
                smin = min;
                min = num;
            }
            else if(num <= smin){
                smin = num;
            }
        }
        
        // System.out.println(min+" "+smin);
        int d = smin - min;
        
        while(set.size() > 0){
            if(set.contains(min)){
                set.remove(min);
                min += d;
            }
            else{
                break;
            }
        }
        
        return set.size() == 0;

    
    }
}



//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main (String[] args) throws IOException{
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while(testcases-- > 0){
            int n=Integer.parseInt(br.readLine());

            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int a[]=new int[n];
            for(int  i=0;i<n;i++)
            {
                a[i]=Integer.parseInt(a1[i]);
            }
            Solution ob=new Solution();

            boolean ans=ob.checkIsAP(a,n);
            if(ans==true)
            System.out.println("YES");
            else
            System.out.println("NO");
        }
    }
}




// } Driver Code Ends