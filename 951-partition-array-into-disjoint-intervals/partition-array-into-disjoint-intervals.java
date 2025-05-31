//TC=O(N) SC=O(N)
/*
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
}*/

//two pointer
class Solution {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int length=1;
        int currMax=nums[0];
        int possibleMax=nums[0];
        for(int i=1;i<n;i++){
            if(nums[i]<currMax){
                length=i+1;
                currMax=possibleMax;
            }else{
                possibleMax=Math.max(possibleMax,nums[i]);
            }
        }
        return length;
    }
}