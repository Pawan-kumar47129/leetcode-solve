class Solution {
    public int minimumOperations(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int left=0;
        int right=0;
        int n=nums.length;
        int ans=0;
        while(right<n){
            while(map.getOrDefault(nums[right],0)==1){
                ans++;
                if(left<n)map.remove(nums[left]);
                if(left+1<n) map.remove(nums[left+1]);
                if(left+2<n) map.remove(nums[left+2]);
                left+=3;
            }
            if(left<=right){
                map.put(nums[right],1);
                right++;
                
            }else{
                right=left;
                if(right<n) map.put(nums[right],1);
                right++;
            }
        }
        return ans;
    }
}