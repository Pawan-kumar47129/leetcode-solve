//TC=O(n) SC=O(2n)
/*
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
}*/

class Solution {
    public int sumOfBeauties(int[] nums) {
        int n=nums.length;
        int []rightMin=new int[n];// this rightMin[i] tell that smallest element till i+1 from right side like i+1 to n-1
        rightMin[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            rightMin[i]=Math.min(nums[i+1],rightMin[i+1]);
        }
        int ans=0;
        int leftMax=nums[0];
        for(int i=1;i<n-1;i++){
            leftMax=Math.max(leftMax,nums[i-1]);
            if(leftMax<nums[i] && rightMin[i]>nums[i]){
                ans+=2;
            }else if(nums[i-1]<nums[i] && nums[i]<nums[i+1]){
                ans+=1;
            }
        }
        return ans;
    }
}