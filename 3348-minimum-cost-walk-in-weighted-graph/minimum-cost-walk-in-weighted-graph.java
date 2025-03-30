class DisJointSet{
    int []parent,size;
    public DisJointSet(int n){
        parent=new int[n];
        size=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
    }
    public int find(int node){
        if(parent[node]==node) return node;
        return parent[node]=find(parent[node]);
    }

    public void union(int u,int v){
        int ultp_u=find(u);
        int ultp_v=find(v);
        if(ultp_u==ultp_v) return;
        if(size[ultp_u]>size[ultp_v]){
            parent[ultp_v]=ultp_u;
            size[ultp_u]+=size[ultp_v];
        }else{
            parent[ultp_u]=ultp_v;
            size[ultp_v]+=size[ultp_u];
        }
    }
}
class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        DisJointSet dsu=new DisJointSet(n);

        //construct the component
        for(int []edge:edges){
            dsu.union(edge[0],edge[1]);
        }
         // All values are initially set to the number with only 1s in its binary representation
        int[]componentCost=new int[n];
        for(int i=0;i<n;i++)componentCost[i]=Integer.MAX_VALUE;
        // Calculate the cost of each component by performing bitwise AND of all edge weights in it
        for(int i=0;i<edges.length;i++){
            int root=dsu.find(edges[i][0]);
            componentCost[root] &=edges[i][2];
        }

        int []ans=new int[query.length];
        for(int i=0;i<query.length;i++){
            int start=query[i][0];
            int end=query[i][1];
            //if the two nodes are in different connected componet return -1
            if(dsu.find(start)!=dsu.find(end)){
                ans[i]=-1;
            }else{
                //find the root of edges component
                int root=dsu.find(start);
                //return the precomputed cost of the component
                ans[i]=componentCost[root];
            }
        }
        return ans;
    }
}