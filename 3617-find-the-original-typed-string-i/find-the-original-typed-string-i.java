class Solution {
    public int possibleStringCount(String word) {
        int ans=1,n=word.length();
        int freqCount=1;
        for(int i=1;i<n;i++){
            if(word.charAt(i)==word.charAt(i-1)){
                freqCount++;
            }else{
                ans+=(freqCount-1);
                freqCount=1;
            }
        }
        ans+=(freqCount-1);
        return ans;
    }
}