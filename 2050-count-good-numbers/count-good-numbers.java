class Solution {
    private final static int mod=(int)1e9+7;
    private long calculate(int num,long pow){
        if(pow==0) return 1L;
        long ans=calculate(num,pow/2);
        long result=(ans%mod*ans%mod)%mod;
        if(pow%2!=0) result=(result*num)%mod;
        return result;
    }
    public int countGoodNumbers(long n) {
        long half=(n+1)/2;
        return(int) (calculate(5,half)%mod*calculate(4,n/2)%mod)%mod;

        
    }
}