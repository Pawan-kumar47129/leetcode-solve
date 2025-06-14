class Solution {
    public int minDifference(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        if(n<=3) return 0;
        int maxIndex=n-1;
        int minIndex=0;
        int min=Math.abs(nums[0]-nums[n-1]);
        n=n-1;
        for(int i=0;i<=3;i++){
            min=Math.min(min,Math.abs(nums[n-i]-nums[3-i]));//changing i elements from last and 3-i element in starting
        }
        return min;
    }
}