class Solution {
    private boolean backtrack(int index,int currSum,int target,int k,int[]nums,boolean[]used){
        if(k==0) return true;
        if(currSum==target) return backtrack(0,0,target,k-1,nums,used);

        for(int i=index;i<nums.length;i++){
            if( !used[i] && currSum+nums[i]<=target){
                used[i]=true;
                if(backtrack(i+1,currSum+nums[i],target,k,nums,used)) return true;
                used[i]=false;
            }
        }
        return false;
    }
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n=nums.length;
        int sum=0;
        for(int ele:nums) sum+=ele;
        if(sum%k!=0) return false;
        int target=sum/k;
        boolean[]used=new boolean[n];
        return backtrack(0,0,target,k,nums,used);
    }
}