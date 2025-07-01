class Solution {
    public List<String> partitionString(String s) {
        HashSet<String>seen=new HashSet<>();
        List<String>ans=new ArrayList<>();
        String currSeg="";
        for(int i=0;i<s.length();i++){
            currSeg+=s.charAt(i);
            if(!seen.contains(currSeg)){
                ans.add(currSeg);
                seen.add(currSeg);
                currSeg="";
            }
        }
        return ans;
    }
}