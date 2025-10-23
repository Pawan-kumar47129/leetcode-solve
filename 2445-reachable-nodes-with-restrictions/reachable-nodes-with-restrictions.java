class Solution {
    private int dfs(int node,List<List<Integer>>adjList,HashSet<Integer>set){
        if(set.contains(node)) return 0;
        set.add(node);
        int ans=1;
        for(var ed:adjList.get(node)){
            ans+=dfs(ed,adjList,set);
        }
        return ans;
    }
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        List<List<Integer>>adjList=new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(var edge:edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        HashSet<Integer>set=new HashSet<>();
        for(var ele:restricted){
            set.add(ele);
        }
        return dfs(0,adjList,set);
    }
}