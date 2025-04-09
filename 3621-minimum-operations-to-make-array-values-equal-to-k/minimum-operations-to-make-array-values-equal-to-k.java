class Solution {
    private void reverse(int[]nums){
        int i=0,j=nums.length-1;
        while(i<j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;j--;
        }
    }
    public int minOperations(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);
        reverse(nums);
        int ans=0;
        for(int i=1;i<n;i++){
            if(nums[i-1]!=nums[i]) ans++;
        }
        if(nums[n-1]<k) return -1;
        if(nums[n-1]==k) return ans;
        return ans+1;//one more steps required to get k


    }
}