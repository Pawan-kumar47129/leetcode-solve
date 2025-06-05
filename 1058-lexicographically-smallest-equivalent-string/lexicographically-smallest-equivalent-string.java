class Solution {
    void dfs(char node,HashMap<Character,List<Character>>map,int[]visited,int currComp,List<Character>minChar){
        visited[node-'a']=currComp;
        if(node < minChar.get(currComp))
            minChar.set(currComp,node);
        for(char ch:map.get(node)){
            if(visited[ch-'a']==-1){
                dfs(ch,map,visited,currComp,minChar);
            }
        }
    }
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        HashMap<Character,List<Character>>map=new HashMap<>();
        int n=s1.length();
        for(int i=0;i<n;i++){
            char ch1=s1.charAt(i);
            char ch2=s2.charAt(i);
            map.putIfAbsent(ch1,new ArrayList<>());
            map.putIfAbsent(ch2,new ArrayList<>());
            map.get(ch1).add(ch2);
            map.get(ch2).add(ch1);
        }
        List<Character>minChar=new ArrayList<>();
        int[]visited=new int[26];
        Arrays.fill(visited,-1);
        int currComp=0;
        for(char ch:map.keySet()){
            if(visited[ch-'a']==-1){
                minChar.add(ch);
                dfs(ch,map,visited,currComp,minChar);
                currComp++;
            }
        }
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<baseStr.length();i++){
            char ch=baseStr.charAt(i);
            int index=visited[ch-'a'];//this gives component number
            if(index!=-1){
                ans.append(minChar.get(index));
            }else{
                ans.append(ch);
            }
        }
        return ans.toString();
    }
}