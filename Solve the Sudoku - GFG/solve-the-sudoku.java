//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver_class
{
    public static void main(String args[])
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int grid[][] = new int[9][9];
            for(int i = 0; i < 9; i++)
            {
                for(int j = 0; j < 9; j++)
                grid[i][j] = sc.nextInt();
            }
            
            Solution ob = new Solution();
            
            if(ob.SolveSudoku(grid) == true)
                ob.printGrid(grid);
            else
                System.out.print("NO solution exists");
            System.out.println();
            
        }
    }
}




// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find a solved Sudoku.
   static boolean ans = false;
   static int [][]save = new int [9][9];
    static void helper(int [][]grid,int i,int j){
        int ni =0;
        int nj =0;
        if(j == grid[0].length-1){
            nj =0;
            ni =i+1;
        }else {
            ni =i;
            nj =j+1;
        }
        if(i == grid.length){
            ans= true;
            for(int x =0;x<grid.length;x++){
                for(int y =0;y<grid[0].length;y++){
                    save[x][y] =grid[x][y]; 
                }
            }
            return;
        }
        if(grid[i][j]!=0){
            helper(grid,ni,nj);
        }else {
            for(int k =1;k<=9;k++){
                if(isValid(grid,i,j,k)){
                     grid[i][j]=k;
                     helper(grid,ni,nj);
                     grid[i][j]=0;
                } 
            }
        }
        
    }
    static boolean isValid(int [][]grid, int x, int y,int val){
        for(int i =0;i<grid.length;i++){
            if(grid[i][y]==val){
                return false;
            }
            
        }
        for(int j =0;j<grid[0].length;j++){
            if(grid[x][j]==val){
                return false;
            }  
        }
        int si = (x/3)*3;
        int sj = (y/3)*3;
        
        for(int i =si;i<si+3;i++){
            for(int j =sj;j<sj+3;j++){
                if(grid[i][j]==val){
                    return false;
                }
            }
        }
        return true;
    }
    
    static boolean SolveSudoku(int grid[][])
    {
        // add your code here
        helper(grid,0,0);
        
        return ans;
        
    }
    
    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][])
    {
        // add your code here
        for(int i =0;i<grid.length;i++){
            for(int j =0;j<grid[0].length;j++){
                System.out.print(save[i][j]+" ");
            }
        }
    }
}