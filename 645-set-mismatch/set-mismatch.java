class Solution {
    public int[] findErrorNums(int[] nums) {
        int n=nums.length;
        List<Integer>list=new ArrayList<>(n+1);
        for(int i=0;i<=n;i++)list.add(0);
        for(int ele:nums){
            list.set(ele,list.get(ele)+1);
        }
        int duplicate=-1,missing=-1;
        for(int i=1;i<=n;i++){
            if(list.get(i)==2) duplicate=i;
            if(list.get(i)==0) missing=i;
        }
        return new int[]{duplicate,missing};
    }
}