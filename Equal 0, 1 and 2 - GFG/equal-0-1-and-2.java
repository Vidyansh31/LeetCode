//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine().trim();
            Solution obj = new Solution();
            System.out.println(obj.getSubstringWithEqual012(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    long getSubstringWithEqual012(String str) 
    { 
        // code here
        long c0 = 0;
        long c1 = 0;
        long c2 = 0;
        
        HashMap<String, Integer> map = new HashMap<>();
        String key = (c1-c0) + "#" + (c2-c1);
        map.put(key,1);
        long res = 0;
        for(char ch : str.toCharArray()){
            
            if(ch == '0'){
                c0++;
            }
            else if(ch == '1'){
                c1++;
            }
            else{
                c2++;
            }
            
            key = (c1-c0) + "#" + (c2-c1);
            
            res += map.getOrDefault(key,0);
            
            map.put(key,map.getOrDefault(key,0)+1);
            
        }
        
        return res;
    }
} 