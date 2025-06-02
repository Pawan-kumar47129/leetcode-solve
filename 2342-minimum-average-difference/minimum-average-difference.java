class Solution {
    public int minimumAverageDifference(int[] nums) {
        long sum=0l;
        for(int ele:nums){
            sum+=ele;
        }
        int n=nums.length;
        long leftSum=0l;
        int ansIndex=-1;
        long minDiff=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            leftSum+=nums[i];
            long leftAve=leftSum/(i+1);
            long rightAve=0;
            if(n-1-i !=0 )rightAve=(sum-leftSum)/(n-1-i);
            long diff=Math.abs(leftAve-rightAve);
            if(diff<minDiff){
                ansIndex=i;
                minDiff=diff;
            }
        }

        return ansIndex;
    }
}