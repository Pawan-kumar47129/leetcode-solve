//memoization
/*
class Solution {
    private long solve(int idx,int[][]questions,Long[]dp){
        if(idx>=questions.length) return 0L;
        if(dp[idx]!=null) return dp[idx];
        //solve curr question
        long solvePoints=questions[idx][0]+solve(idx+questions[idx][1]+1,questions,dp);
        //not solve curr question
        long notSolvePoints=0+solve(idx+1,questions,dp);
        return dp[idx]=Math.max(solvePoints,notSolvePoints);
    }
    public long mostPoints(int[][] questions) {
        int n=questions.length;
        Long[]dp=new Long[n];
        return solve(0,questions,dp);
    }
}
*/
//Tabulation
class Solution {
    public long mostPoints(int[][] questions) {
        int n=questions.length;
        long[]dp=new long[n+1];
        for(int idx=n-1;idx>=0;idx--){
            //solve curr questions
            long solvePoints=questions[idx][0];
            if(idx+questions[idx][1]+1<n){
                solvePoints+=dp[idx+1+questions[idx][1]];
            }
            //not solve curr questions
            long notSolvePoints=dp[idx+1];

            dp[idx]=Math.max(solvePoints,notSolvePoints);
        }
        return dp[0];
    }
}