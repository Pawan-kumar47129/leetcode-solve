class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        n=len(grid)
        drow=[0,0,-1,1]
        dcol=[-1,1,0,0]
        queue=[(grid[0][0],0,0)]
        cost=[[1000000 for _ in range(n)] for _ in range(n)]

        while(queue):
            time,row,col=heapq.heappop(queue)
            if row==n-1 and col==n-1:
                return time
            for d in range(4):
                nrow=row+drow[d]
                ncol=col+dcol[d]
                if nrow>=0 and nrow<n and ncol>=0 and ncol<n:
                    maxTime=max(time,grid[nrow][ncol])
                    if cost[nrow][ncol]>maxTime:
                        cost[nrow][ncol]=maxTime
                        heapq.heappush(queue,(maxTime,nrow,ncol))
        return -1                


        