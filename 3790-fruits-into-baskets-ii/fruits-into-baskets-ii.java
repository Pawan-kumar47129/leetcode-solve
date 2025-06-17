class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n=fruits.length;
        int ans=0;
        boolean []used=new boolean[n];
        for(int i=0;i<n;i++){
            boolean flag=false;
            for(int j=0;j<n;j++){
                if(!used[j] && baskets[j]>=fruits[i]){
                    used[j]=true;
                    flag=true;
                    break;
                }
            }
            if(!flag)ans++;
        }
        return ans;
    }
}