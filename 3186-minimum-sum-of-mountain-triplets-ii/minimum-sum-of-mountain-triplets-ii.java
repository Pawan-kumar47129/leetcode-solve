class Solution {
    public int minimumSum(int[] nums) {
        int n=nums.length;
        int []rightMin=new int[n];
        rightMin[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            rightMin[i]=Math.min(rightMin[i+1],nums[i+1]);
        }
        int leftMin=nums[0];
        int minAns=Integer.MAX_VALUE;
        for(int i=1;i<n-1;i++){
            leftMin=Math.min(leftMin,nums[i-1]);
            if(leftMin<nums[i] && rightMin[i]<nums[i]){
                minAns=Math.min(minAns,nums[i]+leftMin+rightMin[i]);
            }
        }
        if(minAns==Integer.MAX_VALUE) return -1;
        return minAns;
    }
}