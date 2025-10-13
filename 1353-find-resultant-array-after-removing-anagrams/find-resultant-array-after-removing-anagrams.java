class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String>ans=new ArrayList<>();
        ans.add(words[0]);
        for(int i=1;i<words.length;i++){
            int []hash=new int[26];
            for(char ch:words[i].toCharArray()){
                hash[ch-'a']++;
            }
            for(int ch:ans.get(ans.size()-1).toCharArray()){
                hash[ch-'a']--;
            }
            for(int j=0;j<26;j++){
                if(hash[j]!=0){
                    ans.add(words[i]);
                    break;
                }
            }
        }
        return ans;
    }
}