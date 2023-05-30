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
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            char [][] board = new char[n][m];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    board[i][j] = s[j].charAt(0);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(board, word);
            if(ans)
                System.out.println("1");
            else
                System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    public boolean isWordExist(char[][] board, String word)
    {
        // Code here
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    boolean [][]vis=new boolean[board.length][board[0].length];
                    help(board,word,0,i,j,vis);
                }
            }
        }
        return ans;
    }
    boolean ans=false;
    public void help(char[][] grid, String s,int id,int r,int c,boolean [][]vis){
        if(id==s.length()){
            ans=true;
            return;
        }
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || s.charAt(id)!=grid[r][c] || vis[r][c])return;
        vis[r][c]=true;
        help(grid,s,id+1,r+1,c,vis);
        help(grid,s,id+1,r,c+1,vis);
        help(grid,s,id+1,r-1,c,vis);
        help(grid,s,id+1,r,c-1,vis);
    
    }
}