class Solution {
    private boolean dfs(int node,int [][]graph,int[]visited,int[]isSafe,int[]pathTracker){
        visited[node]=1;
        pathTracker[node]=1;
        for(int ele:graph[node]){
            if(visited[ele]==0){
                if(dfs(ele,graph,visited,isSafe,pathTracker)){
                    isSafe[node]=0;
                    return true;
                }
            }else if(pathTracker[ele]==1){//cycle detect
                isSafe[ele]=0;
                return true;
            }
        }
        pathTracker[node]=0;
        isSafe[node]=1;
        return false;

    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        int[]pathTracker=new int[n];
        int[]isSafe=new int[n];
        int[]visited=new int[n];
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                dfs(i,graph,visited,isSafe,pathTracker);
            }
        }
        List<Integer>ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(isSafe[i]==1){
                ans.add(i);
            }
        }
        return ans;
    }
}