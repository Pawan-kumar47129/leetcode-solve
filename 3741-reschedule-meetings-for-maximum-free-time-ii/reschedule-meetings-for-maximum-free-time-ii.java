//Tc=O(n*n)
/*class Solution {
    private boolean findGap(int start,int end,int size,int[]gaps){
        if(start>end) return false;
        while(start<=end){
            if(gaps[start]>=size) return true;
            start++;
        }
        return false;
    }
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n=startTime.length;
        int gaps[]=new int[n+1];
        int prev=0;
        int ans=0;
        for(int i=0;i<n;i++){
            gaps[i]=startTime[i]-prev;
            prev=endTime[i];
        }
        gaps[n]=eventTime-prev;
        int left=0,right=0;
        int currGap=0;
        while(right<gaps.length){
            currGap+=gaps[right];
            if(right-left==1){
                int eventSize=endTime[left]-startTime[left];
                boolean leftFlag=findGap(0,left-1,eventSize,gaps);
                if(leftFlag){
                    ans=Math.max(ans,currGap+eventSize);
                }
                else{
                    boolean rightFlag=findGap(right+1,n,eventSize,gaps);
                    if(rightFlag)ans=Math.max(ans,currGap+eventSize);
                }
                ans=Math.max(ans,currGap);
                currGap-=gaps[left];
                left++;
            }
            right++;
        }
        return ans;
    }
}*/

class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int gaps[] = new int[n + 1];
        int prev = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            gaps[i] = startTime[i] - prev;
            prev = endTime[i];
        }
        gaps[n] = eventTime - prev;
        //preCompute rightMax
        int[] rightMax = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            rightMax[i] = Math.max(gaps[i + 1], rightMax[i + 1]);
        }

        int leftMax = 0, right = 1;
        while (right <= n ) {
            int currGap = gaps[right - 1] + gaps[right];
            int eventSize = endTime[right - 1] - startTime[right - 1];
            if (leftMax >= eventSize || eventSize <= rightMax[right]) {
                ans = Math.max(ans, currGap + eventSize);
            }
            ans = Math.max(ans, currGap);
            leftMax=Math.max(leftMax,gaps[right-1]);
            right++;
        }
        return ans;
    }
}