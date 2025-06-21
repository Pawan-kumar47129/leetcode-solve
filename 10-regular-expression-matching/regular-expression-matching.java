/*class Solution {
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
}*/

//tabulation
/*class Solution {
    public boolean isMatch(String s, String p) {
        int n=s.length();
        int m=p.length();
        boolean[][]dp=new boolean[n+1][m+1];
        dp[0][0]=true;
        for (int j = 2; j <= m; j++) {
            if (p.charAt(j - 1) == '*' && dp[0][j - 2]) {
                dp[0][j] = true;
            }
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.'){
                    dp[i][j]=dp[i-1][j-1];
                }else if(p.charAt(j-1)=='*'){
                    if(s.charAt(i-1)==p.charAt(j-2) || p.charAt(j-2)=='.'){
                        dp[i][j]=dp[i][j-2] || dp[i-1][j];//completely skill two character or matching with p.charAt(j-2) multiple time
                    }else{
                        dp[i][j]=dp[i][j-2];//not matching then skip the both any* any can be . or character
                    }
                }else dp[i][j]=false;
            }
        }
        return dp[n][m];
    }
}*/

//space optimization
class Solution {
    public boolean isMatch(String s, String p) {
        int n=s.length();
        int m=p.length();
        boolean[]dp=new boolean[m+1];
        dp[0]=true;
        for (int j = 2; j <= m; j++) {
            if (p.charAt(j - 1) == '*' && dp[j - 2]) {
                dp[j] = true;
            }
        }
        for(int i=1;i<=n;i++){
            boolean[]curr=new boolean[m+1];
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.'){
                    curr[j]=dp[j-1];
                }else if(p.charAt(j-1)=='*'){
                    if(s.charAt(i-1)==p.charAt(j-2) || p.charAt(j-2)=='.'){
                        curr[j]=curr[j-2] || dp[j];//completely skill two character or matching with p.charAt(j-2) multiple time
                    }else{
                        curr[j]=curr[j-2];//not matching then skip the both any* any can be . or character
                    }
                }else curr[j]=false;
            }
            dp=curr;
        }
        return dp[m];
    }
}