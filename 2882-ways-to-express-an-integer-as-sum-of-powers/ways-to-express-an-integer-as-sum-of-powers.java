class Solution {
    int mod=(int)1e9+7;
    private int solve(int idx,int n,List<Integer>num,Integer[][]dp){
        if(n==0) return 1;
        if(n<0 || idx<0) return 0;
        if(dp[idx][n]!=null) return dp[idx][n]%mod;
        return dp[idx][n]=(solve(idx-1,n-num.get(idx),num,dp)%mod+solve(idx-1,n,num,dp)%mod)%mod;
    }
    public int numberOfWays(int n, int x) {
        List<Integer>num=new ArrayList<>();
        int i=1;
        while(true){
            int value=(int)Math.pow(i,x);
            if(value<=n){
                num.add(value);
                i++;
            }else break;
        }
        Integer[][]dp=new Integer[num.size()][n+1];
        return solve(num.size()-1,n,num,dp);
    }
}