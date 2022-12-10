//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int knapSack(int N, int W, int val[], int wt[])
    {
        // code here
        int [][] t = new int [N+1][W+1];
        for(int i =0;i<t.length;i++){
            for(int j =0;j<t[0].length;j++){
                if(i==0 || j==0){
                    t[i][j]=0;
                }
            }
        }
        for(int i =1;i<t.length;i++){
            for(int j=1;j<t[0].length;j++){
                if(wt[i-1]<=j){
                    t[i][j]= Math.max(val[i-1]+t[i][j-wt[i-1]],t[i-1][j]);
                }else{
                     t[i][j] =t[i-1][j];
                }
            }
        }
        return t[t.length-1][t[0].length-1];
    }
}