//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int equalPartition(int N, int arr[])
    {
        // code here
        int sum=0;
        for(int i =0;i<N;i++){
            sum+=arr[i];
        }
        if(sum%2!=0){
            return 0;
        }
        int tar = sum/2;
        Boolean [][]t = new Boolean[N+1][tar+1];
        Boolean finalAns= isEqualTab(N,tar,arr,t);
        if(finalAns) return 1;
        else return 0;
    }
     public static Boolean isEqualTab(int N,int sum, int arr[],Boolean [][]t){
        
        for(int i =0;i<t.length;i++){
            for(int j =0;j<t[0].length;j++){
                if(j==0){
                    t[i][j]=true;
                }else if(i==0){
                    t[i][j]=false;;
                }
            }
        }
         for(int i =1;i<t.length;i++){
            for(int j =1;j<t[0].length;j++){
                if(arr[i-1]<=j){
                  Boolean ans1 = t[i-1][j-arr[i-1]];
                  Boolean ans2= t[i-1][j]; 
                   t[i][j]=ans1||ans2;
                }else {
                    t[i][j] = t[i-1][j];
                }
                
               
            }
        }
        return t[N][sum];
       
    }
    public static Boolean isEqual(int N,int sum, int arr[],Boolean [][]t){
        if(sum<0 || N<=0){
            return false;
        }
        if(sum==0){
            return true;
        }
        if(t[N-1][sum]!=null){
            return t[N-1][sum];
        }
        Boolean ans1 = isEqual(N-1,sum-arr[N-1],arr,t);
        Boolean ans2 = isEqual(N-1,sum,arr,t);
        return t[N-1][sum]=ans1||ans2; 
    }
}