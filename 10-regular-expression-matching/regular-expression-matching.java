class Solution {
    private boolean func(int i,int j,String s,String p,Boolean[][]dp){
        if(i==0 && j==0) return true;
        if(j==0) return false;
        if(i==0){
            while(j>0){
                if(p.charAt(j-1)!='*') return false;
                j-=2;
            }
            return dp[i][j]= true;
        }
        if(dp[i][j]!=null) return dp[i][j];
        if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.'){
            return dp[i][j]=func(i-1,j-1,s,p,dp);
        }else if(p.charAt(j-1) == '*'){
                if(s.charAt(i-1)==p.charAt(j-2) || p.charAt(j-2)=='.'){
                    return dp[i][j]= func(i,j-2,s,p,dp) || func(i-1,j,s,p,dp);//completely skill two character or matching with p.charAt(j-2) multiple time
                }
                else  return dp[i][j]= func(i,j-2,s,p,dp);//not matching then skip the both any* any can be . or character
        }
        else return dp[i][j]=false;
    }
    public boolean isMatch(String s, String p) {
        int n=s.length();
        int m=p.length();
        Boolean[][]dp=new Boolean[n+1][m+1];
        return func(n,m,s,p,dp);
    }
}