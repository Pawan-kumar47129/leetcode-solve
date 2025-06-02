class Solution {
    private int whereFallTheBall(int col,int[][]grid){
        int n=grid.length,m=grid[0].length;
        int i=0;
        int j=col;
        while(i<n && j<m && j>=0){
            if(( grid[i][j]==1 && ( j==m-1 || grid[i][j+1]==-1 )) || ( grid[i][j]==-1 && (j==0 || grid[i][j-1]==1)) ) return -1;// va shap make this condition

            if(grid[i][j]==1){
                i++;
                j++;
            }else{
                i++;
                j--;
            }
        }
        return j;
    }
    public int[] findBall(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int []ans=new int[m];
        for(int col=0;col<m;col++){
            ans[col]=whereFallTheBall(col,grid);
        }
        return ans;
    }
}