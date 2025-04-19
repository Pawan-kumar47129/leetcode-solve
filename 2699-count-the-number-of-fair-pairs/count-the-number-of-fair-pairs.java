class Solution {
    int lowerBound(int []nums,int low,int target){
        int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]>=target){
                high=mid-1;
            }else {
                low=mid+1;
            }
        }
        return low;
    }
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long ans=0;
        for(int i=0;i<nums.length;i++){
            int low=lowerBound(nums,i+1,lower-nums[i]);
            int high=lowerBound(nums,i+1,upper-nums[i]+1);
            ans+=(high-low);
        }
        return ans;
    }
}