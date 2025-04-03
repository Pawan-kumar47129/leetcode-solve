//Brute force
/*
class Solution {
    public long maximumTripletValue(int[] nums) {
        int n=nums.length;
        long ans=0L;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    ans=Math.max(ans,(nums[i]-nums[j])*(long)nums[k]);
                }
            }
        }
        return ans;
    }
}*/

//optimization on brute force
//TC=O(n^2)
/*class Solution {
    public long maximumTripletValue(int[] nums) {
        int n=nums.length;
        long ans=0L;
        for(int k=2;k<n;k++){
            int iMax=nums[0];
            for(int j=1;j<k;j++){
                ans=Math.max(ans,(iMax-nums[j])*(long)nums[k]);
                iMax=Math.max(iMax,nums[j]);
            }
        }
        return ans;
    }
}*/

//using prefix and suffix array
class Solution {
    public long maximumTripletValue(int[] nums) {
        int n=nums.length;
        int leftMax[]=new int[n];
        int rightMax[]=new int[n];
        for(int i=1;i<n;i++){
            leftMax[i]=Math.max(leftMax[i-1],nums[i-1]);
            rightMax[n-1-i]=Math.max(rightMax[n-i],nums[n-i]);
        }
        long ans=0L;
        for(int j=1;j<n-1;j++){
            ans=Math.max(ans,(leftMax[j]-nums[j])*(long)rightMax[j]);
        }
        return ans;
    }
}