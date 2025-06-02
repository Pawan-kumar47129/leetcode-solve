class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        for(int col=0;col<m;col++){
            int i=1,j=col+1;
            while(i<n && j<m){
                if(matrix[i-1][j-1]!=matrix[i][j]) return false;
                i++;
                j++;
            }
        }  
        for(int row=1;row<n;row++){
            int i=row+1,j=1;
            while(i<n && j<m){
                if(matrix[i-1][j-1]!=matrix[i][j]) return false;
                i++;
                j++;
            }
        }  
        return true;
    }
}