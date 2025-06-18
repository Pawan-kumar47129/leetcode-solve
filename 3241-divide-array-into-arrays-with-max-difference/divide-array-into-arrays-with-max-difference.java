class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n=nums.length;
        int m=n/3;
        int ans[][]=new int[m][3];
        Arrays.sort(nums);
        int currRow=0;
        int currCol=0;
        for(int i=0;i<n;i++){
            ans[currRow][currCol]=nums[i];
            if(ans[currRow][currCol]-ans[currRow][0]>k){
                return new int[0][0];
            }
            currCol++;
            if(currCol==3) {
                currRow++;
                currCol=0;
            }
        }
        return ans;
    }
}