class Solution {
    public List<String> partitionString(String s) {
        HashSet<String>seen=new HashSet<>();
        List<String>ans=new ArrayList<>();
        StringBuilder  currSeg=new StringBuilder();
        for(int i=0;i<s.length();i++){
            currSeg.append(s.charAt(i));
            String seg=currSeg.toString();
            if(!seen.contains(seg)){
                ans.add(seg);
                seen.add(seg);
                currSeg=new StringBuilder();
            }
        }
        return ans;
    }
}