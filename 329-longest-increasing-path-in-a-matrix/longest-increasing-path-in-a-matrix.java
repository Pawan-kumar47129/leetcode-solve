class Solution {
    int n,m,ans;
    private int dfs(int row,int col,int pRow,int pCol,int[][]matrix,int[][]dp){
        if(row<0 || row>=n || col<0 || col>=m)return 0;
        if((row!=pRow || col!=pCol) && matrix[row][col]<=matrix[pRow][pCol]) return 0;
        if(dp[row][col]!=0) return dp[row][col];
        int left=dfs(row,col-1,row,col,matrix,dp);
        int right=dfs(row,col+1,row,col,matrix,dp);
        int up=dfs(row-1,col,row,col,matrix,dp);
        int down=dfs(row+1,col,row,col,matrix,dp);
        dp[row][col]=Math.max(Math.max(left,right),Math.max(up,down))+1;
        ans=Math.max(ans,dp[row][col]);
        return dp[row][col];
    }
    public int longestIncreasingPath(int[][] matrix) {
        n=matrix.length;
        m=matrix[0].length;
        ans=1;
        int[][]dp=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(dp[i][j]==0){
                    dfs(i,j,i,j,matrix,dp);
                }
            }
        }
        return ans;
    }
}