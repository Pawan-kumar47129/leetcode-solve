class Solution {
    int n,m;
    int[]drow={0,0,-1,1};
    int[]dcol={1,-1,0,0};
    private boolean dfs(int row,int col,int parentRow,int parentCol,char[][]grid,boolean[][]visited){
        visited[row][col]=true;
        for(int d=0;d<4;d++){
            int newRow=drow[d]+row;
            int newCol=dcol[d]+col;
            if(newRow<0 || newRow>=n || newCol<0 || newCol>=m || grid[newRow][newCol]!=grid[row][col] )continue;
            if(!visited[newRow][newCol]){
                if(dfs(newRow,newCol,row,col,grid,visited))return true;
            }else if(newRow!=parentRow || newCol!=parentCol) return true;
        }
        return false;
    }
    public boolean containsCycle(char[][] grid) {
        n=grid.length;
        m=grid[0].length;
        boolean[][]visited=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j]){
                    if(dfs(i,j,i,j,grid,visited)) return true;
                }
            }
        }
        return false;
    }
}