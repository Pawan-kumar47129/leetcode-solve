/*class Solution {
    private int helper(int[]nums,int distinct){
        int left=0;
        int right=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        int ans=0;
        while(right<nums.length){
            map.put(nums[right],map.getOrDefault(nums,0)+1);
            while(map.size()>distinct){
                int freq=map.get(nums[left]);
                if(freq==1) map.remove(nums[left]);
                else map.put(nums[left],freq-1);
                left++;
            }
            ans+=(right-left)+1;
            right++;
        }
        return ans;
    }
    public int countCompleteSubarrays(int[] nums) {
        HashSet<Integer>set=new HashSet<>();
        for(var ele:nums){
            set.add(ele);
        }
        int distinct=set.size();
        return helper(nums,distinct)-helper(nums,distinct-1);
    }
}*/

class Solution {

    public int countCompleteSubarrays(int[] nums) {
        int res = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        int n = nums.length;
        int right = 0;
        int distinct = new HashSet<>(
            Arrays.asList(Arrays.stream(nums).boxed().toArray(Integer[]::new))
        ).size();

        for (int left = 0; left < n; left++) {
            if (left > 0) {
                int remove = nums[left - 1];
                cnt.put(remove, cnt.get(remove) - 1);
                if (cnt.get(remove) == 0) {
                    cnt.remove(remove);
                }
            }
            while (right < n && cnt.size() < distinct) {
                int add = nums[right];
                cnt.put(add, cnt.getOrDefault(add, 0) + 1);
                right++;
            }
            if (cnt.size() == distinct) {
                res += (n - right + 1);
            }
        }
        return res;
    }
}