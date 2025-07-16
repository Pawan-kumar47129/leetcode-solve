class Solution {
    public int maximumLength(int[] nums) {
        int even=0,odd=1;
        int lenEven=0,lenOdd=0;
        int evenCount=0,oddCount=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==even){
                even=even==1?0:1;
                lenEven++;
            }
            if(nums[i]%2==odd){
                lenOdd++;
                odd=odd==0?1:0;
            }
            if(nums[i]%2==0)evenCount++;
            else oddCount++;
        }
        int ans1=Math.max(lenEven,lenOdd);
        int ans2=Math.max(evenCount,oddCount);
        return Math.max(ans1,ans2);
    }
}