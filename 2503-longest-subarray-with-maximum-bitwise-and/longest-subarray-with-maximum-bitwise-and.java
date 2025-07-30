class Solution {
    public int longestSubarray(int[] nums) {
        int maxEle=-1,n=nums.length;
        for(int i=0;i<n;i++){
            maxEle=Math.max(maxEle,nums[i]);
        }
        int left=-1,right=0,ans=1;
        while(right<n){
            left=right;
            while(right <n && nums[right]==maxEle){
                ans=Math.max(ans,right-left+1);
                right++;
            }
            right++;
        }
        return ans;
    }
}