//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            int n = Integer.parseInt(read.readLine());
            String str = read.readLine().strip();
            Solution ob = new Solution();
            long ans = ob.minDeletions(str, n); 
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int minDeletions(String s, int n)
    {
         String rs = new StringBuilder(s).reverse().toString();

        int [][] t = new int [s.length()+1][s.length()+1];
        for(int i =0;i<t.length;i++){
            for(int j =0;j<t[0].length;j++){
                if(i==0 || j==0){
                    t[i][j]=0;
                }
            }
        }
        for(int i =1;i<t.length;i++){
            for(int j =1;j<t[0].length;j++){
                if(s.charAt(i-1)==rs.charAt(j-1)){
                    t[i][j]=1+t[i-1][j-1];
                }else {
                    t[i][j]=Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }
       return n-t[t.length-1][t[0].length-1];
    }
} 