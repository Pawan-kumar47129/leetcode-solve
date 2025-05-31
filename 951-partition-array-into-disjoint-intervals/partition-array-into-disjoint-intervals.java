class Solution {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] minArr = new int[n];
        minArr[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            minArr[i] = Math.min(nums[i], minArr[i + 1]);
        }
        int leftMax=nums[0];
        for(int i=1;i<n;i++){
            if(leftMax<=minArr[i]) return i;
            leftMax=Math.max(leftMax,nums[i]);
        }
        return -1;
    }
}