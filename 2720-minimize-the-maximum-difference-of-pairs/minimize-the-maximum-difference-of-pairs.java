class Solution {
    private int countValidPair(int[]nums,int thresholdDiff){
        int count=0;
        int index=0;
        while(index<nums.length-1){
            if(Math.abs(nums[index+1]-nums[index]) <=thresholdDiff){
                count++;
                index++;
            }
            index++;
        }
        return count;
    }
    public int minimizeMax(int[] nums, int p) {
        int n=nums.length;
        Arrays.sort(nums);
        int low=0;
        int high=nums[n-1]-nums[0];
        while(low<=high){
            int mid=low+(high-low)/2;
            if(countValidPair(nums,mid)>=p){
                high=mid-1;
            }else low=mid+1;
        }
        return low;
    }
}