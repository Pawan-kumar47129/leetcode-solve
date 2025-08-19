class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int right=0;
        int n=nums.length;
        long ans=0;
        while(right<n){
            int left=right;
            while(right<n && nums[right]==0){
                right++;
            }
            long item=right-left;
            ans+=(item*(item+1)/2);
            right++;
        }
        return ans;
    }
}