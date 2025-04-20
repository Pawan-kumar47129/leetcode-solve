class Solution {
    /*
    boolean helper(int p,int n){
        if(n==0) return true;
        int pow=(int)Math.pow(3,p);
        if(pow>n) return false;
        //picked mean take pow(3,p)
        boolean picked=false;
        if(pow<=n){
            picked=helper(p+1,n-pow);
        }
        //not picked
        boolean notPicked=helper(p+1,n);
        return picked||notPicked;
    }
    public boolean checkPowersOfThree(int n) {
        return helper(0,n);
    }
    */

    public boolean checkPowersOfThree(int num) {
       //we know that binary representation 
       //like 5=101=>1*2^2 + 0*2^1 + 1*2^0
       // here see 2^2 present one time 2^1 zero time and 2^0 present one time 
       //same way we use trinary representation base 3
       //5=>12=>1*3^1 + 2*3^0  
       // here see 3^1 present one time 3^0 present 2 time so we can't represent 5 as sum of distinct power of 3
       while(num>0){
            if(num%3==2) return false; // 2 time present same power
            num/=3; 
       }
       return true;
    }
}
