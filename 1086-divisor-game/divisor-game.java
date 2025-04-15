class Solution {
    private boolean solve(int n,int turn,Boolean[][]dp){
        if(n==1 && turn==1) return true;//bob's turn but  not able to go next so alice win the game
        if(n==1 && turn ==0) return false;// alice's turn but not able to go next so bob win the game 
        if(dp[n][turn]!=null) return dp[n][turn];
        if(turn==0){//alice turn take that route in which she able to win 
            boolean win=solve(n-1,1,dp);
            if(win) return dp[n][turn]=true;
            //try all other route and take that who in which she win  mean get true, true for alice win
            for(int i=2;i*i<=n;i++){
                if(n%i==0){
                    win=solve(n-i,1,dp) || solve(n-n/i,1,dp);
                    if(win) return dp[n][turn]=true;
                }
            }
            return dp[n][turn]=win;
        }else{//bob turn take that route in which she able to win mean get false result false result show bob win 
            boolean win=solve(n-1,0,dp);
            if(win==false) return dp[n][turn]=false;
            //try all other route and take that who in which he wins mean  get false , false value for bob win
            for(int i=2;i*i<=n;i++){
                if(n%i==0){
                    win=solve(n-i,0,dp) && solve(n-n/i,0,dp);
                    if(!win) return dp[n][turn]=false;
                }
            }
            return dp[n][turn]=win;
        }
    }
    public boolean divisorGame(int n) {
        Boolean[][]dp=new Boolean[n+1][2];
        return solve(n,0,dp);
    }
}