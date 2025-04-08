class Solution {
    public int minIncrementForUnique(int[] nums) {
        List<Integer>duplicate=new ArrayList<>();
        HashSet<Integer>set=new HashSet<Integer>();
        int ans=0;
        for(int ele:nums){
            if(!set.add(ele)){
                duplicate.add(ele);
            }
        }
        if(duplicate.size()==0) return 0;
        Collections.sort(duplicate);
        int greaterNum=duplicate.get(0);
        for(int ele:duplicate){
            if(greaterNum<ele) greaterNum=ele;
            while(set.contains(greaterNum)){
                greaterNum++;
            }
            set.add(greaterNum);
            ans+=(greaterNum-ele);
        }
        return ans;
    }
}