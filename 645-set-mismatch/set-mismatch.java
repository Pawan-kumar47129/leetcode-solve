//Using List TC=O(N) SC=O(N)
/*class Solution {
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
}*/

//using Set TC=O(n) SC=O(n)
/*class Solution {
    public int[] findErrorNums(int[] nums) {
        int n=nums.length;
        HashSet<Integer>set=new HashSet<>(n);
        int setSum=0;
        int duplicate=-1;
        for(int i=0;i<n;i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
                setSum+=nums[i];
            }else{
                duplicate=nums[i];
            }
        }
        int missing=-1;
        for(int i=1;i<=n;i++){
            if(!set.contains(i)){
                missing=i;
                break;
            }
        }
        return new int[]{duplicate,missing};
    }
}*/

//Using HashMap
class Solution {
    public int[] findErrorNums(int[] nums) {
        int n=nums.length;
        int duplicate=-1,missing=-1;
        HashMap<Integer,Integer>map=new HashMap<>(n);
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(int i=1;i<=n;i++){
            int count=map.getOrDefault(i,0);
            if(count==0) missing=i;
            if(count==2) duplicate=i;
        }
        return new int[]{duplicate,missing};
    }
}