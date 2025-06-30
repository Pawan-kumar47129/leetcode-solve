class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int startIndex=0;
        int maxLen=0;
        int n=nums.length;
        int left=0;
        int right=0;
        while(right<n){
            while(left<n && nums[right]-nums[left]>1){
                left++;
            }
            if(nums[right]-nums[left]==1){
                maxLen=Math.max(maxLen,right-left+1);
            }
            right++;
        }
        return maxLen;
    }
}