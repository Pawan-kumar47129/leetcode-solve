class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int n=nums.length;
        List<Integer>ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            ans.add(index[i],nums[i]);
        }
        return ans.stream().mapToInt(i->i).toArray();
    }
}