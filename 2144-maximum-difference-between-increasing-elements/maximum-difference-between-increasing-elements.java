class Solution {
    public int maximumDifference(int[] nums) {
        int n=nums.length;
        int[] rightMax=new int[n];
        rightMax[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            rightMax[i]=Math.max(nums[i],rightMax[i+1]);
        }
        int ans=-1;
        for(int i=0;i<n-1;i++){
            if(nums[i]<rightMax[i+1]){
                ans=Math.max(ans,rightMax[i+1]-nums[i]);
            }
        }
        return ans;
    }
}