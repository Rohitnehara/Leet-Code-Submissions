class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int repCol =image[sr][sc];
         
        if(repCol !=color){
            helper(image,sr,sc,color,repCol);
        } 
        
        return image;
        
    }
    public void helper(int [][] maze,int sr,int sc,int color,int repCol){
        if(sr<0 || sc<0 ||sr>=maze.length || sc>=maze[0].length || maze[sr][sc]!=repCol  ){
            return;
        }
        maze[sr][sc]=color;
        
        //top
        helper(maze,sr-1,sc,color,repCol);
        // down
        helper(maze,sr+1,sc,color,repCol );
        //right
        helper(maze,sr,sc+1,color,repCol );
        //left
        helper(maze,sr,sc-1,color,repCol );
        
    }
}