class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int n=nums.length;
        int left=-1;
        int right=0;
        while(right<n){
            if(nums[right]==1){
                if(left==-1) left=right;
                else{
                    if(right-left-1<k) return false;
                    left=right;
                }
            }
            right++;
        }
        return true;
    }
}