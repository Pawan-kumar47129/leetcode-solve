class Solution {
    
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
}