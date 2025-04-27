class Solution {
    public int countSubarrays(int[] nums) {
        int n=nums.length;
        int ans=0;
        for(int i=2;i<n;i++){
            if(((double)nums[i-2]+nums[i]==nums[i-1]/2d))ans++;
        }
        return ans;
    }
}