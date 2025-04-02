
/*class Solution {
    public long maximumTripletValue(int[] nums) {
        int n=nums.length;
        long ans=0;
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

// some optimization on brute force O(n^2)+greedy
/*class Solution {
    public long maximumTripletValue(int[] nums) {
        int n=nums.length;
        long ans=0;
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

//Using prefix and Suffix Array
class Solution {
    public long maximumTripletValue(int[] nums) {
        int n=nums.length;
        int []leftMax=new int[n];//leftMax[i]->it store maxEle till  i-1 
        int []rightMax=new int[n];
        long ans=0;
        for(int i=1;i<n;i++){
            leftMax[i]=Math.max(leftMax[i-1],nums[i-1]);
            rightMax[n-1-i]=Math.max(rightMax[n-i],nums[n-i]);
        }
        for(int j=1;j<n-1;j++){
            ans=Math.max(ans,(leftMax[j]-nums[j])*(long)rightMax[j]);
        }
        return ans;
    }
}
