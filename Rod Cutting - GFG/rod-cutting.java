//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        //code here
        int size =  price.length;
        int []nArr = new int[n];
        int k =1;
        for(int i =0;i<size;i++){
            nArr[i]=k;
            k++;
        }
        int [][]t = new int [size+1][n+1];
        for(int i =0;i<t.length;i++){
            for(int j =0;j<t[0].length;j++){
                if(i==0 ||j==0){
                    t[i][j]=0;
                }
            }
        }
        for(int i =1;i<t.length;i++){
            for(int j =1;j<t[0].length;j++){
                if(nArr[i-1]<=j){
                    t[i][j]= Math.max(price[i-1]+t[i][j-nArr[i-1]],t[i-1][j]);
                }else {
                    t[i][j]=t[i-1][j];
                }
            }
        }
        return t[t.length-1][t[0].length-1];
    }
}