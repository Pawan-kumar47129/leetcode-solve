class DSU{
    int[]parent;
    public DSU(int n){
        parent=new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i]=i;
        }
    }

    public int findParent(int node){
        if(parent[node]==node) return node;
        return parent[node]=findParent(parent[node]);
    }
    public void join(int u,int v){
        parent[findParent(u)]=findParent(v);
    }
}
class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        DSU dsu=new DSU(c);
        for(int []con:connections){
            dsu.join(con[0],con[1]);
        }
        HashMap<Integer,TreeSet< Integer>>powerGroup=new HashMap<>();
        for(int i=1;i<=c;i++){
            powerGroup.putIfAbsent(dsu.findParent(i),new TreeSet<>());
            powerGroup.get(dsu.findParent(i)).add(i);
        }
        ArrayList<Integer>ans=new ArrayList<>();
        for(int[]query:queries){
            if(query[0]==2){
                powerGroup.get(dsu.findParent(query[1])).remove(query[1]);
            }else{
                int group=dsu.findParent(query[1]);
                if(powerGroup.get(group).contains(query[1])){
                    ans.add(query[1]);
                }else{
                    if(!powerGroup.get(group).isEmpty()){
                        ans.add(powerGroup.get(group).first());
                    }else{
                        ans.add(-1);
                    }
                }
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}