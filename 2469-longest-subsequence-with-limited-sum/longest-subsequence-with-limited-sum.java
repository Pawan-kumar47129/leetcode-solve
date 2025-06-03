class Solution {
    private int binarySearch(int[]prefixSum,int target){
        int low=0;
        int  high=prefixSum.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(prefixSum[mid]<=target){
                low=mid+1;
            }else high=mid-1;
        }
        return high+1;
    }
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n=nums.length;
        int[]prefixSum=new int[n];
        prefixSum[0]=nums[0];
        for(int i=1;i<n;i++){
            prefixSum[i]=prefixSum[i-1]+nums[i];
        }
        int m=queries.length;
        int[]ans=new int[m];
        for(int i=0;i<m;i++){
            ans[i]=binarySearch(prefixSum,queries[i]);
        }
        return ans;
    }
}