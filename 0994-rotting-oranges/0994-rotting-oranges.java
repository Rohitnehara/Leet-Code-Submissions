class Solution {
    public int orangesRotting(int[][] grid) {
        class pair{
            int row;
            int col;
            int time;
            pair(int row,int col,int time){
                this.row=row;
                this.col=col;
                this.time = time;
            }
        }
        int [][] vis = new int[grid.length][grid[0].length];
        int freshCount=0;
        Queue<pair> q=  new LinkedList<>();
        for(int i =0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                int val = grid[i][j];
                if(val ==2){
                    q.add(new pair(i,j,0));
                    vis[i][j]=2;
                }else {
                    vis[i][j]=1;
                }
                if(grid[i][j]==1){
                    freshCount++;
                }
            }
        }
        int maxT=0;
        int cnt=0;
        int []drow ={-1,0,+1,0};
        int []dcol ={0,1,0,-1};
        while(q.size()>0){
            pair p = q.remove();
            int curRow =p.row;
            int curCol = p.col;
            for(int i =0;i<4;i++){
                int nrow = curRow+drow[i];
                int ncol = curCol+dcol[i];
                  maxT= Math.max(maxT,p.time );
                if(nrow>=0 &&ncol>=0 && nrow<grid.length && ncol<grid[0].length && vis[nrow][ncol]!=2){
                    if(grid[nrow][ncol]==1){
                        q.add(new pair(nrow,ncol,p.time+1));
                        vis[nrow][ncol]=2;
                        cnt++;
                    }
                }
            }
            
        }
        if(cnt!=freshCount){
            return -1;
        }
        return maxT;
    }
}