class Solution {
    public int numSub(String s) {
        int n=s.length();
        int left=0,right=0;
        int ans=0;
        int mod=1000000007;
        while(right<n){
            char ch=s.charAt(right);
            right++;
            if(ch=='1'){
                ans=(ans+(right-left)%mod)%mod;
            }else{
                left=right;
            }
        }
        return ans;
    }
}