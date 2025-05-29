//brute force Tc=O(n*2n + m*2m);
/*class Solution {
    private int dfs(int node,int parent,List<List<Integer>>adjList,boolean even,int k){
        int count=0;
        if(even && k%2==0)count=1;
        if(!even && k%2==1)count=1;
        for(int neighbors:adjList.get(node)){
            if(neighbors==parent) continue;
            count+=dfs(neighbors,node,adjList,even,k+1);
        }
        return count;
    }
    private int[]buildTree(int[][]edges, boolean even){
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
            count[i]=dfs(i,-1,adjList,even,0);
        }
        return count;
    }
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int even[]=buildTree(edges1,true);
        int odd[]=buildTree(edges2,false);
        int n=edges1.length+1;
        int[]ans=new int[n];
        int maxOdd=0;
        for(int dd:odd){
            if(dd>maxOdd)maxOdd=dd;
        }
        for(int i=0;i<n;i++){
            ans[i]=even[i]+maxOdd;
        }
        return ans;
    }
}*/

class Solution {
    private void dfs(int node,int parent,List<List<Integer>>adjList,int depth,int[]color,int[]maxCount){
        if(depth==0){
            maxCount[0]++;
        }else maxCount[1]++;
        color[node]=depth;
        for(int neighbors:adjList.get(node)){
            if(neighbors==parent) continue;
            int d=depth==1?0:1;
            dfs(neighbors,node,adjList,d,color,maxCount);
        }
    }
    private int[] buildTree(int[][]edges,int[]color){
        int n=edges.length+1;
        List<List<Integer>>adjList=new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(var edge:edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        int[]maxCount=new int[2];
        dfs(0,-1,adjList,0,color,maxCount);
        return maxCount;
    }
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int n=edges1.length+1;
        int m=edges2.length+1;
        int[]color1=new int[n];
        int[]color2=new int[m];
        int[]maxCount1=buildTree(edges1,color1);
        int[]maxCount2=buildTree(edges2,color2);
        int[]ans=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=maxCount1[color1[i]]+Math.max(maxCount2[0],maxCount2[1]);
        }
        return ans;
    }
}