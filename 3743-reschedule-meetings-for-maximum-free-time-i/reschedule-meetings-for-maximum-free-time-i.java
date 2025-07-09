class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        List<Integer>gaps=new ArrayList<>();
        int prev=0,n=startTime.length;
        for(int i=0;i<n;i++){
            int gap=startTime[i]-prev;
            gaps.add(gap);
            prev=endTime[i];
        }
        int gap=eventTime-prev;
        gaps.add(gap);
        //if k resedule means k+1 gap merge
        System.out.println(gaps);
        int i=0,j=0,ans=0,currGapSum=0;
            while(j<gaps.size()){
                currGapSum+=gaps.get(j);
                if(j-i+1>k+1){
                    currGapSum-=gaps.get(i);
                    i++;
                }
                ans=Math.max(ans,currGapSum);
                j++;
            }
            return ans;
        }
}