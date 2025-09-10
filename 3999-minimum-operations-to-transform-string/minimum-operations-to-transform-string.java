/*class Solution {
    public int minOperations(String s) {
        int ans=0;
        TreeMap<Character,Integer>charMap=new TreeMap<>((a,b)->a-b);
        for(char ch:s.toCharArray()){
            charMap.put(ch,charMap.getOrDefault(ch,0)+1);
        }
        while(charMap.size()>0){
            char ch=charMap.firstKey();
            int freq=charMap.get(ch);
            if(ch=='a'){
                charMap.remove(ch);
            }else{
                int nextIdx=((ch-'a')+1)%26;
                char nextChar=(char)('a'+ nextIdx);
                charMap.put(nextChar,charMap.getOrDefault(nextChar,0)+freq);
                charMap.remove(ch);
                ans++;
            }
        }
        return ans;
    }
}*/

class Solution {
    public int minOperations(String s) {
        int ans=0;
        int[]freq=new int[26];
        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }
        for(int i=1;i<26;i++){
            if(freq[i]!=0){
                ans++;
                freq[(i+1)%26]+=freq[i];
            }
        }
        return ans;
    }
}
