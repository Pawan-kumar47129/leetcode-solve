class Solution {
    private void findSum(int idx,long sum,int end,int[]nums,List<Long>listSum){
        if(idx > end){
            listSum.add(sum);
            return ;
        }
        findSum(idx+1,sum+nums[idx],end,nums,listSum);
        findSum(idx+1,sum,end,nums,listSum);
    }
    private int lowerBound(List<Long>rightSum,long target){
        int low=0;
        int high=rightSum.size()-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(rightSum.get(mid)>=target){
                high=mid-1;
            }else low=mid+1;
        }
        return low;
    }
    public int minAbsDifference(int[] nums, int goal) {
        int n=nums.length;
        int half=(n-1)/2;
        List<Long>leftSum=new ArrayList<>();//first half
        List<Long>rightSum=new ArrayList<>();//second half
        findSum(0,0l,half,nums,leftSum);
        findSum(half+1,0l,n-1,nums,rightSum);
        Collections.sort(rightSum);
        int minDiff=Integer.MAX_VALUE;
        for(int i=0;i<leftSum.size();i++){
            long target=goal-leftSum.get(i);
            int lowerIdx=lowerBound(rightSum,target);
            if(lowerIdx<rightSum.size()){
                minDiff=Math.min(minDiff,(int)Math.abs(target-rightSum.get(lowerIdx)));
            }
            if(lowerIdx>0){
                minDiff=Math.min(minDiff,(int)Math.abs(target-rightSum.get(lowerIdx-1)));
            }
        }
        return minDiff;
    }
}