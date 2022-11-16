//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Driver
{
    public static void main(String args[]) 
	{ 
	    Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int []a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            
            int  m= sc.nextInt();
            int []b = new int[m];
            for (int i = 0; i < m; i++) b[i] = sc.nextInt();
            
            double res = new GFG().medianOfArrays(n, m, a, b);
            
            if (res == (int)res) System.out.println ((int)res);
            else System.out.println (res);
        }
    		
	} 
}
// } Driver Code Ends


//User function Template for Java

class GFG 
{ 
    static double medianOfArrays(int n, int m, int a[], int b[]) 
    {
        // Your Code Here
        int []bigArr =  new int [n+m];
        int k=0;
        for(int i =0;i<n;i++){
            bigArr[k++]=a[i];
        }
        for(int i =0;i<m;i++){
            bigArr[k++]=b[i];
        }
        Arrays.sort(bigArr);
        int len =bigArr.length;
        int half = len/2;
        if(len%2==0){
            double ans = ((double)bigArr[half-1]+(double)bigArr[half])/2.0;
            return ans;
        }else{
            return bigArr[len/2];
        }
    }
}