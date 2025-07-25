class Solution {
    public int maxSum(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int ans=0;
        int maxEle=nums[0];
        for(var ele:nums){
            if(ele>0){
                if(!map.containsKey(ele)){
                    ans+=ele;
                    map.put(ele,1);
                }
            }
            maxEle=Math.max(ele,maxEle);
        }
        if(maxEle>=0) return ans;
        return maxEle;

    }
}