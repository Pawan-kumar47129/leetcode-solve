class Solution {
    int n,m;
    int mod=(int)1e9+7;
    private long dfs(int row,int col,int pRow,int pCol,int[][]grid,long[][]dp){
        if(row<0 || row>=n || col<0 || col>=m) return 0;
        if((row!=pRow ||col!=pCol) && grid[row][col]<=grid[pRow][pCol]) return 0;
        if(dp[row][col]!=0) return dp[row][col];
        long left=dfs(row,col-1,row,col,grid,dp);
        long right=dfs(row,col+1,row,col,grid,dp);
        long up=dfs(row-1,col,row,col,grid,dp);
        long down=dfs(row+1,col,row,col,grid,dp);
        dp[row][col]=(left+right+up+down+1)%mod;
        return dp[row][col];
    }
    public int countPaths(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        long ans=0l;
        long[][]dp=new long[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                long curr=dfs(i,j,i,j,grid,dp);
                ans=(ans+curr)%mod;
            }
        }
        return (int)ans;
    }
}