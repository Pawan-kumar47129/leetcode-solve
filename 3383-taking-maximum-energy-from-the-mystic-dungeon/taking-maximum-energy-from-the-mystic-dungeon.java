class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int[] dp=new int[k];
        int last=k-1,n=energy.length;
        int ans=Integer.MIN_VALUE;
        for(int i=n-1;i>=n-k;i--){
            dp[last]=energy[i];
            ans=Math.max(ans,dp[last]);
            last--;
        }
        last=k-1;
        for(int i=n-k-1;i>=0;i--){
            dp[last]+=energy[i];
            ans=Math.max(ans,dp[last]);
            last--;
            if(last<0){
                last=k-1;//again start 
            }
        }
        return ans;
    }
}