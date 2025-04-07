class Solution {
    public int sumOfBeauties(int[] nums) {
        int n=nums.length;
        int []leftMax=new int[n];//this leftMax[i] tells that greatest element till i-1 from left side like 0 to i-1
        int []rightMin=new int[n];// this rightMin[i] tell that smallest element till i+1 from right side like i+1 to n-1
        leftMax[0]=nums[0];
        rightMin[n-1]=nums[n-1];
        for(int i=1;i<n;i++){
            leftMax[i]=Math.max(nums[i-1],leftMax[i-1]);
            rightMin[n-1-i]=Math.min(nums[n-i],rightMin[n-i]);
        }
        int ans=0;
        for(int i=1;i<n-1;i++){
            if(leftMax[i]<nums[i] && rightMin[i]>nums[i]){
                ans+=2;
            }else if(nums[i-1]<nums[i] && nums[i]<nums[i+1]){
                ans+=1;
            }
        }
        return ans;
    }
}