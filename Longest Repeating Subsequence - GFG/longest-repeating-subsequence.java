//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.LongestRepeatingSubsequence(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestRepeatingSubsequence(String str)
    {
        int [][]t = new int[str.length()+1][str.length()+1];
        for(int i =1;i<t.length;i++){
            for(int j =1;j<t[0].length;j++){
                 if(str.charAt(i-1) ==str.charAt(j-1) && i!=j){
                     t[i][j] = t[i-1][j-1]+1;
                 }else {
                     t[i][j] =Math.max(t[i-1][j],t[i][j-1]);
                 }
            }
        }
        return t[t.length-1][t.length-1];
    }
}