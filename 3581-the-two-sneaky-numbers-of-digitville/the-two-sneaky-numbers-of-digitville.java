class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        HashSet<Integer>set=new HashSet<>();
        int []ans=new int[2];
        int i=0;
        for(var ele:nums){
            if(set.contains(ele)){
                ans[i++]=ele;
            }
            else set.add(ele);
        }
        return ans;
    }
}