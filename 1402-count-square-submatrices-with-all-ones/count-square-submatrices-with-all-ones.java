class Solution {
    int n,m;
    private int solve(int i,int j,int[][]matrix,Integer[][]dp){
        if(i>=n || j>=m || matrix[i][j]==0) return 0;
        if(dp[i][j]!=null) return dp[i][j];
        int right=solve(i,j+1,matrix,dp);
        int dig=solve(i+1,j+1,matrix,dp);
        int down=solve(i+1,j,matrix,dp);
        return dp[i][j]=1+ Math.min(right,Math.min(dig,down));
    }
    public int countSquares(int[][] matrix) {
        n=matrix.length;
        m=matrix[0].length;
        int result=0;
        Integer[][]dp=new Integer[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==1){
                    result+=solve(i,j,matrix,dp);
                }
            }
        }
        return result;
    }
}