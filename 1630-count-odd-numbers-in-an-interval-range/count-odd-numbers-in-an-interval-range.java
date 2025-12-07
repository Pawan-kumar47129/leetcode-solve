class Solution {
    public int countOdds(int low, int high) {
        int ans=(high-low)/2;
        if(low%2==1 && high%2==1){
            ans+=1;
        }else{
            ans+=low%2==1?1:0;
            ans+=high%2==1?1:0;
        }
        return ans;
    }
}