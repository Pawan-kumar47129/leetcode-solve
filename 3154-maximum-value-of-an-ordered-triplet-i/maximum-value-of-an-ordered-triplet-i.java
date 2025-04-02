
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

// some optimization on brute force O(n^2)
class Solution {
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
}
