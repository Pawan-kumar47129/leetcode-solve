class Solution {
    private boolean dfs(int node,int parentColor,List<Integer>[]adjList,int[]ans){
        for(int neighbor:adjList[node]){//check all adjacent garden not have same color if same then backtrack
            if(ans[neighbor-1]==parentColor) return false;
        }
        ans[node-1]=parentColor;//color it
        for(int neighbor:adjList[node]){
            if(ans[neighbor-1]==0){//not visited
                for(int color=1;color<=4;color++){
                    if(dfs(neighbor,color,adjList,ans)) break;
                }
            }    
        }
        return true;
    }
    public int[] gardenNoAdj(int n, int[][] paths) {
        int[]ans=new int[n];
        List<Integer>[]adjList=new List[n+1];
        for(int i=1;i<=n;i++){
            adjList[i]=new ArrayList<>();
        }
        for(int[]path:paths){
            adjList[path[0]].add(path[1]);
            adjList[path[1]].add(path[0]);
        }
        for(int i=1;i<=n;i++){
            if(ans[i-1]==0){
                for(int color=1;color<=4;color++){
                    if(dfs(i,color,adjList,ans)) break;
                }
            }
        }
        return ans;
    }

}