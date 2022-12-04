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
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    List<Integer> posible = new ArrayList<>();
	public int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	    int sum =0;
	    for(int a : arr){
	        sum+= a;
	    }
	    boolean [][] subset = new boolean [n+1][sum+1];
	    subSetSum(arr,sum,subset);
	    int  min = Integer.MAX_VALUE;
	    
	    int mx=-1;
	    //min = Math.min(min,Math.abs((totalSum-s1)-s1));
	    for(int i =0;i<posible.size();i++){
	       // System.out.println(posible.get(i));
	       int s1=posible.get(i);
	        min = Math.min(min,Math.abs((sum-s1)-s1));
	       // mx=posible.get(i);
	        
	    }
	    //min=3;
	    return min;
	    
	} 
	public void subSetSum (int arr[],int sum,boolean [][] t){
	    for(int i =0;i<t.length;i++){
	        for(int j =0;j<t[0].length;j++){
	            if(i==0){
	                t[i][j]=false;
	            }
	            if(j==0){
	                t[i][j]=true;
	            }
	        }
	    }
	     
	    for(int i =1;i<t.length;i++){
	        for(int j =1;j<t[0].length;j++){
	            if(arr[i-1]<=j){
	               t[i][j] =t[i-1][j] || t[i-1][j-arr[i-1]];
	            }else {
	                t[i][j]= t[i-1][j];
	            }
	        }
	    }
	  
	    for(int j =0;j<t[0].length;j++){
	        if(t[t.length-1][j]){
	            posible.add(j);
	        }
	    }
	}
}
