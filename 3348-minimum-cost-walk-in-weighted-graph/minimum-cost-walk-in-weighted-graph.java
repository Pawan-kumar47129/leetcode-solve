//Using DisJointSet TC=(N+E+Q)
/*
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
}*/

class Solution {
    private int getComponentCost(int src,List<List<int[]>>adjList,int[]component,int componentId,boolean[]visited){
        Queue<Integer>queue=new LinkedList<>();
        queue.add(src);
        visited[src]=true;
        int componentCost=Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            int node=queue.poll();
            //mark the node as part of the current component
            component[node]=componentId;
            // Explore all neighbors of the current node
            for(int[]neighbor:adjList.get(node)){
                int weight=neighbor[1];
                 // Update the component cost by performing a bitwise AND of the edge weights
                componentCost &=weight;
                // If the neighbor hasn't been visited, mark it as visited and add it to the queue
                if(visited[neighbor[0]]) continue;
                queue.add(neighbor[0]);
                visited[neighbor[0]]=true;
            }
        }
        return componentCost;
    }
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        //make adjList
        List<List<int[]>>adjList=new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int[]edge:edges){
            adjList.get(edge[0]).add(new int[]{edge[1],edge[2]});
            adjList.get(edge[1]).add(new int[]{edge[0],edge[2]});
        }
        boolean[]visited=new boolean[n];
        //Array to store componentId for each node
        int[]component=new int[n];
        int[]componentCost=new int[n];
        int componentId=0;
        //perform bfs for each unvisited node to indentify components and calculate their cost
        for(int node=0;node<n;node++){
            if(!visited[node]){
                componentCost[componentId]=getComponentCost(node,adjList,component,componentId,visited);
                componentId++;
            }
        }

        //gives ans of each query
        int[]ans=new int[query.length];
        for(int i=0;i<query.length;i++){
            int start=query[i][0];
            int end=query[i][1];
            if(component[start]!=component[end]){//if both node are not in same componentId
                ans[i]=-1;
            }else{
                ans[i]=componentCost[component[start]];//find cost of conponent[start]id
            }
        }
        return ans;
    }
}