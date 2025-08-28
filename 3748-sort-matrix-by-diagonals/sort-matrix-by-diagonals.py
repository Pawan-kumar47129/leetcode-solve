class Solution:
    def sortMatrix(self, grid: List[List[int]]) -> List[List[int]]:
        n=len(grid)
        ans=[ [0 for _ in range(n)] for _ in range(n)]
        for i in range(n):
            row=i
            col=0
            curr=[]
            while row<n and col<n:
                curr.append(grid[row][col])
                row+=1; col+=1
            curr.sort(reverse=True)
            row=i;col=0;idx=0
            while row<n and col<n:
                ans[row][col]=curr[idx]
                idx+=1;row+=1;col+=1
        for j in range(1,n):
            row=0;col=j;curr=[]
            while (row<n and col<n):
                curr.append(grid[row][col])
                row+=1; col+=1
            curr.sort()    
            row=0;col=j;idx=0
            while row<n and col<n:
                ans[row][col]=curr[idx]
                idx+=1;row+=1;col+=1
        return ans        
        