//{ Driver Code Starts
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
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


class Solution
{
    class Pair{
        int row;
        int col;
        int dist;
        Pair(int row,int col,int dist){
            this.row=row;
            this.col = col;
            this.dist=dist;
        }
    }
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        boolean [][]vis = new boolean[n][m];
        int [][] ans = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    q.add(new Pair(i,j,0));
                    vis[i][j]=true;
                }
            }
        }
        int [] drow ={1,0,-1,0};
        int [] dcol ={0,1,0,-1};
        while(q.size()>0){
            Pair p = q.remove();
            int row =p.row;
            int  col = p.col;
            int dist=p.dist;
            ans[row][col]=dist;
            for(int i=0;i<4;i++){
               int currCol = col+dcol[i];
               int currRow = row+drow[i];
               if(currRow<n && currCol<m && currRow>=0 && currCol>=0){
                if(vis[currRow][currCol]==false){
                    q.add(new Pair(currRow,currCol,dist+1));
                    vis[currRow][currCol]=true;
                 }
               }
              
              
            }
        }
        return ans;
    }
}