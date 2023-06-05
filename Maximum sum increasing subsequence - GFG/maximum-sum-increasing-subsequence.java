//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSumIS(Arr,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    Integer [][]dp;
	public int maxSumIS(int arr[], int n)  
	{  
	    //code here
	    dp=new Integer[n][n+1];
	    return help(arr,0,-1);
	}
	public int help(int []arr,int id,int pId){
	    if(id==arr.length)return 0;
	    if(dp[id][pId+1]!=null)return dp[id][pId+1];
	    
	    int val2=0; 
	    if(pId==-1 || arr[id]>arr[pId]){
	        val2=Math.max(help(arr,id+1,id)+arr[id],help(arr,id+1,pId));
	        
	    }
	    int val1=help(arr,id+1,pId);
	    return dp[id][pId+1]=Math.max(val2,val1);
	}
}