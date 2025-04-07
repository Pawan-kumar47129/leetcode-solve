class Solution {
    private boolean solve(int n,int target,int[]nums,Boolean[][]dp){
        if(target==0) return true;
        if(n<0) return false;
        if(dp[n][target]!=null) return dp[n][target];
        //picked
        boolean picked=false;
        if(target>=nums[n]){
            picked=solve(n-1,target-nums[n],nums,dp);
        }
        //not picked
        boolean notPicked=solve(n-1,target,nums,dp);
        return dp[n][target]=picked||notPicked;
    }
    public boolean canPartition(int[] nums) {
        int sum=0;
        int n=nums.length;
        for(int ele:nums){
            sum+=ele;
        }
        if(sum%2!=0) return false;
        int target=sum/2;
        Boolean[][]dp=new Boolean[n][target+1];
        return solve(n-1,target,nums,dp);

    }
}