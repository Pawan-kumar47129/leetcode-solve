class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        long ans=0;
        int mod=(int)(1e9+7);
        int left=0;
        int right=nums.length-1;
        int n=nums.length;
        int []power=new int [n];
        power[0]=1;
        for(int i=1;i<n;i++){
            power[i]=(power[i-1]*2)%mod;
        }
        while(left<=right){
            if(nums[left]+nums[right]<=target){
                int diff=right-left;
                ans=(ans+power[diff])%mod;
                left++;
            }else right--;
        }
        return (int)ans;
    }
}