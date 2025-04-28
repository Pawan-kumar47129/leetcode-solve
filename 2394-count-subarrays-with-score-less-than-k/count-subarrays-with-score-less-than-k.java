class Solution {
    public long countSubarrays(int[] nums, long k) {
        int left=0,right=0,n=nums.length;
        long sum=0l;
        long ans=0l;
        while(right<n){
            sum+=nums[right];
            int len=(right-left)+1;
            long product=sum*len;
            while(product>=k){
                sum-=nums[left];
                left++;
                len=(right-left)+1;
                product=sum*len;
            }
            ans+=right-left+1;
            right++;
        }
        return ans;
    }
}