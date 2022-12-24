//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GfG { 
    
	public static void main (String[] args) throws IOException  {
	    
	    //reading input using BufferedReader class
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//reading total testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    
		    //reading number of eggs and floors
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    int n = Integer.parseInt(inputLine[0]);
		    int k = Integer.parseInt(inputLine[1]);
		    
		    //calling eggDrop() method of class
		    //EggDrop
		    System.out.println(new Solution().eggDrop(n, k));
		}
	}
}



// } Driver Code Ends


class Solution 
{
    //Function to find minimum number of attempts needed in 
    //order to find the critical floor.
    static int eggDrop(int e, int f) 
	{
	    // Your code here
	     Integer [][] dp = new Integer[e+1][f+1];
        return solve(e,f,dp);
	}
	 static  int solve(int e, int f, Integer [][] dp){
        if(e==1){
            return f;
        }
        if(f==0 || f==1){
            return f;
        }
        if(dp[e][f]!=null){
            return dp[e][f];
        }
        int min =Integer.MAX_VALUE;
        for(int k =1;k<=f;k++){
            int val1 =-1;
             if(dp[e-1][k-1]!=null){
                val1= dp[e-1][k-1];
             }else {
                val1 = solve(e-1,k-1,dp);
             }
             int val2 =-1;
             if(dp[e][f-k]!=null){
                val2= dp[e][f-k];
             }else {
                val2 = solve(e,f-k,dp);
             }
            int temp =1+Math.max(val1,val2);
            min = Math.min(min,temp);
        }
        return dp[e][f]=min;
    }
}