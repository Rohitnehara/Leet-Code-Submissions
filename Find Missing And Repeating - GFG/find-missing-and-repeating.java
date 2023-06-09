//{ Driver Code Starts
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
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
        int xor =0;
        for(int i=1;i<=n;i++){
            xor^=i;
        }
        for(int i=0;i<n;i++){
            xor^=arr[i];
        }
        int rmsb =xor & -xor;
        int val1=0;
        int val2=0;
        for(int i=1;i<=n;i++){
            if((i&rmsb)==0){
                val1^=i;
            }else {
                val2^=i;
            }
        }
        for(int i=0;i<n;i++){
            if((arr[i]&rmsb)==0){
                val1^=arr[i];
            }else {
                val2^=arr[i];
            }
        }
        int []ans=new int[2];
        for(int val : arr){
            if(val==val1){
                ans[0]=val1;
                ans[1]=val2;
                return ans;
            }
            if(val==val2){
                ans[0]=val2;
                ans[1]=val1;
                return ans;
            }
        }
        return ans;
    }
}