class Solution {
    public int minOperations(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);
        int ans=0;
        for(int i=n-2;i>=0;i--){
            if(nums[i+1]!=nums[i]) ans++;
        }
        if(nums[0]<k) return -1;
        if(nums[0]==k) return ans;
        return ans+1;//one more steps required to get k


    }
}