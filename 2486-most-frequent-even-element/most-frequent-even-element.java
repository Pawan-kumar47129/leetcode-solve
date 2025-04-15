class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int ans=-1;
        int maxFreq=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0){
                int freq=map.getOrDefault(nums[i],0);
                freq+=1;
                if(freq==maxFreq){
                    ans=Math.min(ans,nums[i]);
                    maxFreq=freq;
                }else if(freq>maxFreq){
                    ans=nums[i];
                    maxFreq=freq;
                }
                map.put(nums[i],freq);
            }
        }
        return ans;
    }
}