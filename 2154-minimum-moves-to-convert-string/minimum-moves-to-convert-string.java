class Solution {
    public int minimumMoves(String s) {
        int ans=0;
        int n=s.length();
        int start=0;
        while(start<n){
            if(s.charAt(start)=='X'){
                ans++;
                start+=3;
            }else start++;
        }
        return ans;
    }
}