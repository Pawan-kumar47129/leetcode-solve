class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int ans=0;
        int left=0;
        int currSum=0;
        for(int right=0;right<nums.length;right++){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            currSum+=nums[right];
            while(map.get(nums[right])>1){
                map.put(nums[left],map.get(nums[left])-1);
                currSum-=nums[left];
                left++;
            }
            ans=Math.max(ans,currSum);
        }
        return ans;
    }
}