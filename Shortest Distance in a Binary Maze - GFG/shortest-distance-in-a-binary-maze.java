//{ Driver Code Starts
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
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
class Pair{
        int row;
        int col;
        int dist;
        Pair(int row,int col,int dist){
            this.row = row;
            this.col =col;
            this.dist =dist;
        } 
    }
    int shortestPath(int[][] grid, int[] source, int[] destination) {
        int n =grid.length;
        int m = grid[0].length;
        int [][]dist  = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j =0;j<m;j++){
                dist[i][j]= (int)1e9;
            }
        }
        int sr = source[0];
        int sc = source[1];
        
        int dr  = destination[0];
        int dc  = destination[1];
        dist[sr][sc]=0;
       int [] drow ={1,0,-1,0};
       int [] dcol ={0,1,0,-1};

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr,sc,0));

        while(q.size()>0){
            Pair p = q.remove();
            int r = p.row;
            int c =p.col;
            int pdist = p.dist;
            if(r==dr && c==dc){
                return pdist;
            }
            for(int i =0;i<4;i++){
                int nrow = r+drow[i];
                int ncol =c+dcol[i];
                if(nrow<n && ncol <m && nrow >=0 && ncol>=0 && grid[nrow][ncol]== 1 && pdist+1<dist[nrow][ncol]){
                    q.add(new Pair(nrow,ncol,pdist+1));
                    dist[nrow][ncol]=pdist+1;
                }
            }
        }
        return -1;
    }
}

