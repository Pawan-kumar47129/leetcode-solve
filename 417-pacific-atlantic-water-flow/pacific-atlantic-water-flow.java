class Solution {
    int n,m;
    int[]drow={0,0,-1,1};
    int[]dcol={1,-1,0,0};
    private void dfs(int row,int col,int[][]heights,int[][]visited){
        visited[row][col]=1;
        for(int d=0;d<4;d++){
            int nrow=row+drow[d];
            int ncol=col+dcol[d];
            if(nrow<0 || nrow>=n || ncol<0 || ncol>=m || visited[nrow][ncol]==1 || heights[nrow][ncol] < heights[row][col])continue;
            dfs(nrow,ncol,heights,visited);
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        n=heights.length;
        m=heights[0].length;
        int[][]pacific=new int[n][m];
        int[][]atlantic=new int[n][m];
        for(int i=0;i<n;i++){
            dfs(i,0,heights,pacific);
            dfs(i,m-1,heights,atlantic);
        }
        for(int j=0;j<m;j++){
            dfs(0,j,heights,pacific);
            dfs(n-1,j,heights,atlantic);
        }
        List<List<Integer>>ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int  j=0;j<m;j++){
                if(pacific[i][j]==1 && atlantic[i][j]==1){
                    ans.add(Arrays.asList(i,j));
                }
            }
        }
        return ans;
    }
}