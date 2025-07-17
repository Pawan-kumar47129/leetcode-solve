/*
class Solution {
    private int solve(int index,int prev1,int prev2,int[]nums,int k){
        if(index>=nums.length) return 0;
        int take=0;
        if(prev1==-1 || prev2==-1 || nums[prev1]+nums[prev2]%k==nums[prev1]+nums[index]%k){
            take=1+solve(index+1,index,prev1,nums,k);
        }
        int notTake=solve(index+1,prev1,prev2,nums,k);
        return Math.max(take,notTake);
    }
    public int maximumLength(int[] nums, int k) {
        return solve(0,-1,-1,nums,k);
    }
}*/
// using lis
class Solution {
    public int maximumLength(int[] nums, int k) {
        int n=nums.length;
        int[][]dp=new int[n][k];//state dp[i][j] till ith index maxLenth of subsequence whose module is j;
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],1);
        }
        int ans=2;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                int mod=(nums[i]+nums[j])%k;
                dp[i][mod]=Math.max(dp[i][mod],dp[j][mod]+1);
                ans=Math.max(ans,dp[i][mod]);
            }
        }
        return ans;
    }
}
