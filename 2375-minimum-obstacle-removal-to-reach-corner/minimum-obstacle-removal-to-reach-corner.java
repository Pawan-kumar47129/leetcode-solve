class Solution {
    public int minimumObstacles(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][]cost=new int[n][m];
        for(int i=0;i<n;i++) Arrays.fill(cost[i],(int)1e5);
        cost[0][0]=0;
        PriorityQueue<int[]>queue=new PriorityQueue<>((a,b)->a[2]-b[2]);
        queue.add(new int[]{0,0,0});
        int[]drow={-1,1,0,0};
        int[]dcol={0,0,-1,1};
        while(!queue.isEmpty()){
            int[]curr=queue.poll();
            int row=curr[0],col=curr[1],obstacles=curr[2];
            if(row==n-1 && col==m-1) return obstacles;
            for(int i=0;i<4;i++){
                int newRow=row+drow[i];
                int newCol=col+dcol[i];
                if(newRow>=0 && newRow<n && newCol>=0 && newCol<m){
                    int currCost=obstacles+grid[newRow][newCol];
                    if(currCost<cost[newRow][newCol]){
                        cost[newRow][newCol]=currCost;
                        queue.add(new int[]{newRow,newCol,currCost});
                    }
                }
            }
        }

        return cost[n-1][m-1];
    }
}