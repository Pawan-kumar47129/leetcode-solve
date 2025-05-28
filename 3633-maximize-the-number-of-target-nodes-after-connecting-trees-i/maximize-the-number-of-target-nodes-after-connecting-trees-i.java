class Solution {
    private int dfs(int node, int parent, List<List<Integer>> adjList, int k) {
        if (k < 0)
            return 0;
        int res = 1;
        for (int neighbors : adjList.get(node)) {
            if (neighbors == parent)
                continue;
            res += dfs(neighbors, node, adjList, k - 1);
        }
        return res;
    }

    private int[] build(int[][]edges,int k){
        int n=edges.length+1; 
        List<List<Integer>>adjList=new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(var edge:edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        int []count=new int[n];
        for(int i=0;i<n;i++){
            count[i]=dfs(i,-1,adjList,k);
        }
        return count;
    }

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int count1[] = build(edges1, k);
        int count2[] = build(edges2, k - 1);
        int n= edges1.length+1;
        int[] ans=new int[n];
        int maxCount2 = 0;
        for (int c : count2) {
            if (c > maxCount2)
                maxCount2 = c;
        }
        for (int i = 0; i < n; i++) {
            ans[i] = count1[i] + maxCount2;
        }
        return ans;
    }
}