//brute force
//TC=O(n*(n+e))
/*
class Solution {
    int ans=0;
    private boolean dfs(int node,List<List<Integer>>adjList,boolean[]visited,String colors,boolean[]pathTracker,HashMap<Character,Integer>map){
        visited[node]=true;
        pathTracker[node]=true;
        char color=colors.charAt(node);
        map.put(color,map.getOrDefault(color,0)+1);
        ans=Math.max(ans,map.get(color));
        for(int ele:adjList.get(node)){
            if(!visited[ele] || (visited[ele] && !pathTracker[ele])){
                if(dfs(ele,adjList,visited,colors,pathTracker,map)) return true;
            }else{
                return true;//cycle
            }
        }
        pathTracker[node]=false;
        map.put(color,map.get(color)-1);
        return false;
    }
    public int largestPathValue(String colors, int[][] edges) {
        List<List<Integer>>adjList=new ArrayList<>();
        int n=colors.length();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            adjList.get(edge[0]).add(edge[1]);
        }

        boolean[]visited=new boolean[n];
        boolean[]pathTracker=new boolean[n];
        HashMap<Character,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(!visited[i]){
                if(dfs(i,adjList,visited,colors,pathTracker,map)){
                    return -1;
                }
            }
        }
        return ans;
    }
}*/

class Solution {
    int ans=0;
    private boolean dfs(int node,List<List<Integer>>adjList,String colors,int[]visited,int[][]dp){
        visited[node]=1;//process
        for(int neighbors:adjList.get(node)){
            if(visited[neighbors]==0){
                if(dfs(neighbors,adjList,colors,visited,dp)) return true;
                for(int i=0;i<26;i++){
                    dp[node][i]=Math.max(dp[node][i],dp[neighbors][i]);
                    ans=Math.max(ans,dp[node][i]);
                }
            }else if(visited[neighbors]==2){// already visited and not in same path 
                for(int i=0;i<26;i++){
                    dp[node][i]=Math.max(dp[node][i],dp[neighbors][i]);
                    ans=Math.max(ans,dp[node][i]);
                }
            }else{//visited[neighbors]==1 means visited and in same path so cycle contains
                return true;
            }
        }
        char ch=colors.charAt(node);
        dp[node][ch-'a']++;
        ans=Math.max(ans,dp[node][ch-'a']);
        visited[node]=2;//visited completed one path
        return false;
    }
    public int largestPathValue(String colors, int[][] edges) {
        List<List<Integer>>adjList=new ArrayList<>();
        int n=colors.length();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            adjList.get(edge[0]).add(edge[1]);
        }

        int[]visited=new int[n];// 0 =not visited ,1=process and in same path  2=complete visited
        int[][]dp=new int[n][26];//at every node we store all color frequency count
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                if(dfs(i,adjList,colors,visited,dp)){
                    return -1;
                }
            }
        }
        return ans;

    }
}