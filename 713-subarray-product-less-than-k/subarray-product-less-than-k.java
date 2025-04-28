class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left=0,right=0,n=nums.length;
        long product=1l;
        int ans=0;
        while(right<n){
            product*=nums[right];
            while(product>=k && left<=right){
                product/=nums[left];
                left++;
            }
            ans+=right-left+1;
            right++;
        }
        return ans;
    }
}