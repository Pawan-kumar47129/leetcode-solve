from collections import deque
class Solution:
    def maxDistance(self, grid: List[List[int]]) -> int:
        n=len(grid)
        queue: deque[List[int]] = deque()
        visited:List[List[bool]]=[[False for _ in range(n)] for _ in range(n)]
        for i in range(0,n):
            for j in range(0,n):
                if grid[i][j]==1:
                    queue.append([i,j,0])
                    visited[i][j]=True
        drow=[0,0,-1,1]
        dcol=[1,-1,0,0]
        ans=-1
        while len(queue) is not 0:
            row,col,dist=queue.popleft()
            for i in range(4):
                nrow=row+drow[i]
                ncol=col+dcol[i]
                if nrow>=0 and nrow<n and ncol>=0 and ncol<n and not visited[nrow][ncol]:
                    ans=max(ans,dist+1)
                    queue.append([nrow,ncol,dist+1])
                    visited[nrow][ncol]=True
        return ans            

            
