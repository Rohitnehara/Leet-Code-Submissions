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
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends


class Solution{

	public int perfectSum(int arr[],int n, int sum) 
	{ 
	   return util(arr,sum);
	    
	} 
	int m  =(int) Math.pow(10,9)+7;
	 public int util(int []nums ,int target){
        int [][]t =new int[nums.length+1][target+1];
        for(int i =0;i<t.length;i++){
            for(int j =0;j<t[0].length;j++){
                if(i ==0){
                    t[i][j]=0;
                }
                if(j==0){
                    t[i][j] =1;
                }
            }
        }
    t[0][0]=1;
        for(int i=1;i<t.length;i++ ){
            for(int j =0;j<t[0].length;j++){
                if(nums[i-1]<=j){
                    t[i][j] = (t[i-1][j-nums[i-1]] + t[i-1][j])%m;
                }
                else {
                    t[i][j]=t[i-1][j]%m;
                }
            }
        }
        return t[t.length-1][t[0].length-1];
    }
}