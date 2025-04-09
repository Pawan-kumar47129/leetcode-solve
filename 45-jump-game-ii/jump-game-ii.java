class Solution {
    public int jump(int[] nums) {
        int minRange=0,maxRange=0,steps=0,n=nums.length;
        while(maxRange<n-1){
            int farthest=maxRange;
            for(int i=minRange;i<=maxRange;i++){
                farthest=Math.max(farthest,nums[i]+i);
            }
            minRange=maxRange+1;
            maxRange=farthest;
            steps++;
        }
        return steps;
    }
}