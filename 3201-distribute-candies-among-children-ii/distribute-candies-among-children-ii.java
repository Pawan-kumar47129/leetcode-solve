class Solution {
    public long distributeCandies(int n, int limit) {
        long ways=0;
        int ch1Min=Math.max(0,n-2*limit);
        int ch1Max=Math.min(limit,n);
        for(int i=ch1Min;i<=ch1Max;i++){
            int rest=n-i;//rest candi for ch2 and ch3
            int ch2Min=Math.max(0,rest-limit);
            int ch2Max=Math.min(rest,limit);
            ways+=ch2Max-ch2Min+1;
        }
        return ways;
    }
}