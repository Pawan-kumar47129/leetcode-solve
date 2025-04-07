//Memoizatio
/*
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
}*/

//Tabulation
/*class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        int n=nums.length;
        for(int ele:nums){
            sum+=ele;
        }
        if(sum%2!=0) return false;
        int target=sum/2;
        boolean[][]dp=new boolean[n][target+1];
        if(nums[0]<=target)dp[0][nums[0]]=true;
        for(int i=1;i<n;i++){
            for(int t=0;t<=target;t++){
                //picked
                boolean picked=false;
                if(t>=nums[i]){
                    picked=dp[i-1][t-nums[i]];
                }
                //not picked
                boolean notPicked=dp[i-1][t];
                dp[i][t]=picked||notPicked;
            }
        }
        return dp[n-1][target];

    }
}*/

//Space optimization
class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        int n=nums.length;
        for(int ele:nums){
            sum+=ele;
        }
        if(sum%2!=0) return false;
        int target=sum/2;
        boolean[]dp=new boolean[target+1];
        if(nums[0]<=target)dp[nums[0]]=true;
        for(int i=1;i<n;i++){
            boolean[]curr=new boolean[target+1];
            for(int t=0;t<=target;t++){
                //picked
                boolean picked=false;
                if(t>=nums[i]){
                    picked=dp[t-nums[i]];
                }
                //not picked
                boolean notPicked=dp[t];
                curr[t]=picked||notPicked;
            }
            dp=curr;
        }
        return dp[target];

    }
}