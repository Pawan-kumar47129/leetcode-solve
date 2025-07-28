class Solution {
    private int dfs(int idx,long currOr,int[]nums,long maxOr){
        if(idx>=nums.length){
            return currOr==maxOr?1:0;
        }

        return dfs(idx+1,currOr|nums[idx],nums,maxOr) + 
                dfs(idx+1,currOr,nums,maxOr);
    }
    public int countMaxOrSubsets(int[] nums) {
        long maxOr=0;
        for(var ele:nums)maxOr|=ele;
        return dfs(0,0,nums,maxOr);
    }
}