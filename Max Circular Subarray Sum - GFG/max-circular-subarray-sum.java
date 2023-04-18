//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());// input size of array
		    int arr[] = new int[n];
		    String inputLine2[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine2[i]); // input elements of array
		    }
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.circularSubarraySum(arr, n));// print the circularSubarraySum
		}
	}
}



// } Driver Code Ends


class Solution{

    // a: input array
    // n: size of array
    //Function to find maximum circular subarray sum.
    static int circularSubarraySum(int a[], int n) {
        int minSum=0;
        int sum=0;
        int total=0;
        int overAllMax=Integer.MIN_VALUE;
         for(int i=0;i<n;i++){ 
             overAllMax=Math.max(overAllMax,a[i]);
             total+=a[i];
             sum+=a[i];
             minSum=Math.min(minSum,sum);
             if(sum>0){
                 sum=0;
             } 
         }
         int maxSum=0;
         sum=0;
         for(int i=0;i<n;i++){
             sum+=a[i];
             maxSum=Math.max(maxSum,sum);
             if(sum<0){
                 sum=0;
             } 
         }
         if(maxSum<=0){
             return overAllMax;
         }
         return Math.max(overAllMax,(Math.max(total-minSum,maxSum)));
    }
    
}

