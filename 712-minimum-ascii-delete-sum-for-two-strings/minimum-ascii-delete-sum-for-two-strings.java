//Memoization TC=O(n*m) Sc=O(n*m)+O(n+m)
/*class Solution {
    long solve(int i,int j,String s1,String s2,Long[][]dp){
        if(i<=0 || j<=0) return 0;
        if(dp[i][j]!=null) return dp[i][j];
        if(s1.charAt(i-1) == s2.charAt(j-1)){
            return dp[i][j]=solve(i-1,j-1,s1,s2,dp)+s1.charAt(i-1);
        }else{
            return dp[i][j]=Math.max(solve(i-1,j,s1,s2,dp),solve(i,j-1,s1,s2,dp));
        }
    }
    public int minimumDeleteSum(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        Long[][]dp=new Long[n+1][m+1];
        long lcsSum=solve(n,m,s1,s2,dp);
        long allCharASCII=0;
        for(int i=0;i<n;i++){
            allCharASCII+=s1.charAt(i);
        }
        for(int i=0;i<m;i++){
            allCharASCII+=s2.charAt(i);
        }

        return (int)(allCharASCII-lcsSum*2);  
    }
}*/

//Tabulation TC=O(n*m) Sc=O(n*m)+O(n+m)
/*class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        long[][]dp=new long[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+s1.charAt(i-1);
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        long lcsSum=dp[n][m];
        long allCharASCII=0;
        for(int i=0;i<n;i++){
            allCharASCII+=s1.charAt(i);
        }
        for(int i=0;i<m;i++){
            allCharASCII+=s2.charAt(i);
        }
        return (int)(allCharASCII-lcsSum*2);  
    }
}*/

//Space optimization O(n*m) Sc=O(m)
class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        long[]dp=new long[m+1];
        for(int i=1;i<=n;i++){
            long curr[]=new long[m+1];
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    curr[j]=dp[j-1]+s1.charAt(i-1);
                }else{
                    curr[j]=Math.max(dp[j],curr[j-1]);
                }
            }
            dp=curr;
        }
        long lcsSum=dp[m];
        long allCharASCII=0;
        for(int i=0;i<n;i++){
            allCharASCII+=s1.charAt(i);
        }
        for(int i=0;i<m;i++){
            allCharASCII+=s2.charAt(i);
        }
        return (int)(allCharASCII-lcsSum*2);  
    }
}