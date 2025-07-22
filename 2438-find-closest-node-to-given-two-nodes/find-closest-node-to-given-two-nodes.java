class Solution {
    private int[]bfs(int []edges,int src){
        int n=edges.length;
        Queue<Integer>queue=new LinkedList<>();
        int []dist=new int[n];
        Arrays.fill(dist,(int)1e6);
        dist[src]=0;
        queue.add(src);
        while(!queue.isEmpty()){
            int node=queue.poll();
            int nextDist=dist[node]+1;
            if(edges[node]!=-1 && dist[edges[node]]>nextDist){
                queue.add(edges[node]);
                dist[edges[node]]=nextDist;
            }
        }
        return dist;
    }
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n=edges.length;
        int dist1[]=bfs(edges,node1);
        int dist2[]=bfs(edges,node2);
        int ans=n+1;
        int minDist=(int)1e6;
        for(int i=0;i<n;i++){
            int distance=Math.max(dist1[i],dist2[i]);
            if(minDist>distance){
                minDist=distance;
                ans=i;
            }
        }
        if(minDist==1e6) return -1;
        return ans;
    }
}