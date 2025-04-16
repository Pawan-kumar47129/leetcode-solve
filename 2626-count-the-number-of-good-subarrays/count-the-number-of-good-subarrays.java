class Solution {
    public long countGood(int[] nums, int k) {
        long ans=0;
        long pair=0;
        int left=0,right=0,n=nums.length;
        HashMap<Integer,Integer>map=new HashMap<>();
        while(right<n){
            int freq=map.getOrDefault(nums[right],0);
            pair+=freq;
            map.put(nums[right],freq+1);
            while(pair>=k){
                ans+=(n-right);
                int leftFreq=map.get(nums[left]);
                map.put(nums[left],leftFreq-1);
                pair-=(leftFreq-1);
                left++;
            }
            right++;
        }
        return ans;
    }
}