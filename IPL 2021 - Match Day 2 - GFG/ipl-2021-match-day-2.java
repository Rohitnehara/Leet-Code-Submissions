//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String args[]) {
        // taking input using class Scanner
        Scanner sc = new Scanner(System.in);

        // taking total count of testcases
        int t = sc.nextInt();

        while (t-- > 0) {
            // taking total number of elements
            int n = sc.nextInt();

            // taking size of subArrays
            int k = sc.nextInt();

            // Declaring and Intializing an array of size n
            int arr[] = new int[n];

            // adding all the elements to the array
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            // Calling the method max_of_subarrays of class solve
            // and storing the result in an ArrayList
            ArrayList<Integer> res = new Solution().max_of_subarrays(arr, n, k);

            // printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++)
                System.out.print(res.get(i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {
    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        // Your code here
        int i =0;
        int j =0;
        List<Integer> li = new ArrayList<>();
        
        ArrayList<Integer> ans = new ArrayList<>();
        while(j<arr.length){
            while(li.size()>0 && li.get(li.size()-1)<arr[j]){
                li.remove(li.size()-1);
            }
            li.add(arr[j]);
            if(j-i+1<k){
                j++;
            }else {
                ans.add(li.get(0));
                if(li.get(0)==arr[i]){
                    li.remove(0);
                }
                i++;
                j++;
            }
        }
        return ans;
    }
}