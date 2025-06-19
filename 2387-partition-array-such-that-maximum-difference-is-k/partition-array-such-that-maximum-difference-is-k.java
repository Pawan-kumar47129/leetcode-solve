class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int ans=1;
        int firstElement=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]-firstElement>k){
                ans++;
                firstElement=nums[i];
            }
        }
        return ans;
    }
}