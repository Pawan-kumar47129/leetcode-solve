class Solution {
    private int binarySerach(int[][]events,int target){
        int left=0;
        int right=events.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(events[mid][0]<=target){
                left=mid+1;
            }else right=mid-1;
        }
        return left;
    }
    private int dfs(int index,int k,int[][]events,Integer[][]dp){
        if(index>=events.length || k==0) return 0;
        if(dp[index][k]!=null) return dp[index][k];
        //attend the current events
        int nextIndex=binarySerach(events,events[index][1]);
        int attend=dfs(nextIndex,k-1,events,dp)+events[index][2];
        //do not attend the currents Event
        int notAttend=dfs(index+1,k,events,dp);
        return dp[index][k]=Math.max(attend,notAttend);
    }
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events,(a,b)->a[0]-b[0]);
        int n=events.length;
        Integer[][]dp=new Integer[n][k+1];
        return dfs(0,k,events,dp);
    }
}