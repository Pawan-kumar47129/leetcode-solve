class Solution {
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        PriorityQueue<int[]>queue=new PriorityQueue<>((a,b)->a[0]-b[0]);
        queue.add(new int[]{grid[0][0],0,0});
        int []drow={0,0,-1,1};
        int []dcol={-1,1,0,0};
        int[][]cost=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(cost[i],1000000);
        }
        while(!queue.isEmpty()){
            int[]curr=queue.poll();
            int time=curr[0],row=curr[1],col=curr[2];
            if(row==n-1 && col==n-1) return time;
            for(int d=0;d<4;d++){
                int nrow=row+drow[d];
                int ncol=col+dcol[d];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<n){
                    int maxTime=Math.max(time,grid[nrow][ncol]);
                    if(cost[nrow][ncol]>maxTime){
                        cost[nrow][ncol]=maxTime;
                        queue.add(new int[]{maxTime,nrow,ncol});
                    }
                }
            }
        }
        return -1;
    }
}