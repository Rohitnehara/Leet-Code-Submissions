class Solution {
    public boolean checkValid(int[][] matrix) {
         int n =matrix.length;
        HashSet<Integer> chs = new HashSet<>();
        for(int i =1;i<=n;i++){
            chs.add(i);
        }
        for(int i =0;i<matrix.length;i++){
            HashSet<Integer> hs = (HashSet)chs.clone();
            for(int j=0;j<matrix[0].length;j++){
                if(hs.contains(matrix[i][j])){
                    hs.remove(matrix[i][j]);
                    }
                else {
                    return false;
                }
            }
        }
        for(int j =0;j<matrix.length;j++){
            HashSet<Integer> hs = (HashSet)chs.clone();
            for(int i=0;i<matrix[0].length;i++){
                if(hs.contains(matrix[i][j])){
                    hs.remove(matrix[i][j]);
                }else {
                     return false;
                }
            }
        }
        return true;
    }
}