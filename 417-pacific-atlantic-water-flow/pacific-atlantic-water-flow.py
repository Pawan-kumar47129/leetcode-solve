class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        n,m = len(heights),len(heights[0])
        drow=[0,0,-1,1]
        dcol=[-1,1,0,0]
        pacific=[[0 for _ in range(m)] for _ in range(n)]
        atlantic=[[0 for _ in range(m)] for _ in range(n)]

        def dfs(row:int ,col:int,visited:List[List[int]])->None:
            visited[row][col]=1
            for d in range(4):
                nrow=row+drow[d]
                ncol=col+dcol[d]
                if(nrow<0 or nrow>=n or ncol<0 or ncol>=m or visited[nrow][ncol]==1 or heights[nrow][ncol]<heights[row][col]):  continue
                dfs(nrow,ncol,visited)
        for i in range(n):
            dfs(i,0,pacific)
            dfs(i,m-1,atlantic)
        for j in range(m):
            dfs(0,j,pacific)
            dfs(n-1,j,atlantic)
        ans=[]
        for i in range(n):
            for j in range(m):
                if(pacific[i][j]==1 and atlantic[i][j]==1):
                    ans.append([i,j])
        return ans                    
        