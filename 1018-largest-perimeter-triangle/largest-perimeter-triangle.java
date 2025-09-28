//brute force TC=O(n^3)
/*class Solution {
    public int largestPerimeter(int[] nums) {
        int ans=0,n=nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    if(nums[i]+nums[j]>nums[k] && nums[i]+nums[k]>nums[j] && nums[j]+nums[k]>nums[i]){
                        ans=Math.max(ans,nums[i]+nums[j]+nums[k]);
                    }
                }
            }
        }
        return ans;
    }
}*/

class Solution {
    public int largestPerimeter(int[] nums) {
        int ans=0,n=nums.length;
        Arrays.sort(nums);
        for(int i=n-1;i>=2;i--){
            if(nums[i-2]+nums[i-1]>nums[i]){
                return nums[i-2]+nums[i-1]+nums[i];
            }
        }
        return 0;
    }
}