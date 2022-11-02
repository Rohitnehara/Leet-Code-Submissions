//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.numberOfEnclaves(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int count=0;
    
    public void dfs(int [][] grid,int i,int j,boolean[][] vis){
        if(i>=grid.length || j>= grid[0].length || j<0 || i<0 || vis[i][j]==true || grid[i][j]== 0){
            return;
        }
        vis[i][j]=true;
        count++;
        dfs(grid,i+1,j,vis);
        dfs(grid,i,j+1,vis);
        dfs(grid,i-1,j,vis);
        dfs(grid,i,j-1,vis);
        
    }

    int numberOfEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
         boolean [][]vis= new boolean[n][m];
        
        for(int i =0,j=0; j<m;j++){
           if(grid[i][j]==1){
               dfs(grid,i,j,vis);
           }
        }
        for(int i =0,j=m-1; i<n;i++){
           if(grid[i][j]==1){
               dfs(grid,i,j,vis);
           }
        }
         for(int i =n-1,j=m-1;j>=0;j--){
           if(grid[i][j]==1){
               dfs(grid,i,j,vis);
           }
        }
         for(int i =n-1,j=0;i>=0;i--){
           if(grid[i][j]==1){
               dfs(grid,i,j,vis);
           }
        }
        int OneCount=0;
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    OneCount++;
                }
            }
        }
        return OneCount - count;
    }
}