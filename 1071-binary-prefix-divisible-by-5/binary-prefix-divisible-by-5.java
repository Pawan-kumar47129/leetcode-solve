class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        int ans=0;
        List<Boolean>list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            ans=ans<<1;
            if(nums[i]==1){
                ans+=1;
            }
            ans=ans%5;
            if(ans==0){
                list.add(true);
            }else{
                list.add(false);
            }
        }
        return list;

    }
}