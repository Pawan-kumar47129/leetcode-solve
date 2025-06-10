class Solution {
    public int maxDifference(String s) {
        int[] hash=new int[26];
        for(int i=0;i<s.length();i++){
            hash[s.charAt(i)-'a']++;
        }
        int oddMax=1;
        int evenMin=100;
        for(int i=0;i<26;i++){
            if(hash[i]!=0 && hash[i]%2==1){
                oddMax=Math.max(oddMax,hash[i]);
            }
            if(hash[i]!=0 && hash[i]%2==0){
                evenMin=Math.min(evenMin,hash[i]);
            }
        }
        return oddMax-evenMin;
    }
}