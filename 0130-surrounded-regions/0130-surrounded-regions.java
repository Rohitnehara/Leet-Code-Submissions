class Solution {
    public void dfs(char [][] board,int i ,int j,boolean[][]vis){
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || vis[i][j] || board[i][j] == 'X'){
            return;
        }
        vis[i][j]=true;
        dfs(board,i+1,j,vis);
        dfs(board,i,j+1,vis);
        dfs(board,i-1,j,vis);
        dfs(board,i,j-1,vis);
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean [][] vis = new boolean [n][m];
        for(int i =0,j=0;j<m;j++){
            if(board[i][j]=='O'){
                dfs(board,i,j,vis);
            }
        }
        for(int i =0,j=m-1;i<n;i++){
            if(board[i][j]=='O'){
                dfs(board,i,j,vis);
            }
        }
        for(int i =n-1,j=m-1;j>=0;j--){
            if(board[i][j]=='O'){
                dfs(board,i,j,vis);
            }
        }
        for(int i=n-1,j=0;i>=0;i--){
            if(board[i][j]=='O'){
                dfs(board,i,j,vis);
            }
        }
    for(int i =0;i<n;i++){
        for(int j =0;j<m;j++){
            if(board[i][j]== 'O' && vis[i][j]==false){
                board[i][j]='X';
            }
        }
    }
    }
   
}