class Solution {
    public int longestSubarray(int[] nums) {
        int ans=1;
        int count=0;
        int last=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                count++;
            }
            while(count>1){
                if(nums[last]==0) count--;
                last++;
            }
            ans=Math.max(ans,i-last+1);
        }
        return ans-1;
    }
}