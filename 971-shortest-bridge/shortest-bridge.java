class Solution {
    int n;
    int []drow={0,0,1,-1};
    int []dcol={-1,1,0,0};
    private void dfs(int row,int col,int[][]grid,boolean[][]visited,Queue<int[]>queue){
        queue.add(new int[]{row,col,0});
        visited[row][col]=true;
        for(int i=0;i<4;i++){
            int nrow=drow[i]+row;
            int ncol=dcol[i]+col;
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<n && grid[nrow][ncol]==1 && !visited[nrow][ncol]){
                dfs(nrow,ncol,grid,visited,queue);
            }
        }
    }
    public int shortestBridge(int[][] grid) {
        // first find one cell which is island after that make land to connect all connect island after the find the
        n=grid.length;
        boolean[][]visited=new boolean[n][n];
        Queue<int[]>queue=new LinkedList<>();
        for(int i=0;i<n;i++){
            boolean flag=false;
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    flag=true;
                    dfs(i,j,grid,visited,queue);// all cell in queue which is part of one land
                    break;
                }
            }
            if(flag) break;
        }
        // do bfs and find the smallest dist to reach another island 
        while(!queue.isEmpty()){
            int[]curr=queue.poll();
            int row=curr[0],col=curr[1],dist=curr[2];
            for(int i=0;i<4;i++){
                int nrow=drow[i]+row;
                int ncol=dcol[i]+col;
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<n && !visited[nrow][ncol]){
                    if(grid[nrow][ncol]==1) return dist;
                    queue.add(new int[]{nrow,ncol,dist+1});
                    visited[nrow][ncol]=true;
                }
            }
        }
        return -1;
    }
}