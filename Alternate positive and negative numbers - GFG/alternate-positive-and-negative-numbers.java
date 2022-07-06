// { Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().rearrange(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java




class Solution {
    void rightrotate(int[] arr, int from , int to){
        int temp = arr[to];
        for(int i = to ; i > from; i--){
            arr[i] = arr[i-1];
        }
        arr[from] = temp;
    }
    void rearrange(int arr[], int n) {
        // code here
        int wrongIndex = -1;
        for(int i = 0; i < n ; i++){
            if(wrongIndex != -1){
                if(arr[wrongIndex] >= 0 && arr[i] < 0 || arr[wrongIndex] < 0 && arr[i] >= 0 ){
                    rightrotate(arr,wrongIndex, i);
                    
                    if(i - wrongIndex >= 2){
                        wrongIndex += 2;
                    }
                    else{
                        wrongIndex = -1;
                    }
                }
            }
            else{
                if(i%2 == 0 && arr[i] < 0){
                    wrongIndex = i;
                }
                
                if(i%2 == 1 && arr[i] >= 0){
                    wrongIndex = i;
                }
            }
        }
    }
}