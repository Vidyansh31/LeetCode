// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int A[], int n) {
        // code here
     int xor = 0 ;

        for(int i =1 ;i<=A.length ;i++){
            xor ^= i ;
        }

        for(int i =0 ; i<A.length ;i++){
            xor ^= A[i] ;
        }

        int rmsb = xor & -xor ;

        int f = 0 ;
        int s = 0 ;

        for(int i =0 ;i<A.length ;i++ ){
            if((A[i]&rmsb)==0)
                f ^= A[i] ;
            else
                s ^= A[i] ;
        }

        for(int i = 1 ;i<=A.length ;i++ ){
            if((i&rmsb)==0)
                f ^= i ;
            else
                s ^= i ;
        }

        int[] arr = new int[2] ;

        int first = -1 ;

        for(int i = 0 ;i<A.length ;i++ ){
            if(A[i]==f)
            first = f ;
            if(A[i]==s)
            first = s ;
        }
        

        if(first==f){
            arr[0] = first ;
            arr[1] = s ;
            return arr ;
        }

        arr[0] = s ;
        arr[1] = f ;
        return arr ;


        

    }

}

