class Solution {
    public int maxDistance(int[][] grid) {
        int n=grid.length;
        boolean[][]visited=new boolean[n][n];    
        Queue<int[]>queue=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    queue.add(new int[]{i,j,0});
                    visited[i][j]=true;
                }
            }
        }
        int[]drow={0,0,-1,1};
        int[]dcol={1,-1,0,0};
        int ans=-1;
        while(!queue.isEmpty()){
            int[]curr=queue.poll();
            int row=curr[0],col=curr[1],dist=curr[2];
            for(int i=0;i<4;i++){
                int nrow=row+drow[i];
                int ncol=col+dcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<n && !visited[nrow][ncol]){
                    ans=Math.max(ans,dist+1);
                    queue.add(new int[]{nrow,ncol,dist+1});
                    visited[nrow][ncol]=true;
                }
            }
        }
        return ans;

    }
}