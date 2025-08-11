class Solution {
    public int[] productQueries(int n, int[][] queries) {
        List<Integer>power=new ArrayList<>();
        int count=0;
        while(n>0){
            if(n%2==1){
                power.add((1<<count));
            }
            n/=2;
            count++;
        }
        int q=queries.length;
        int[]ans=new int[q];
        int mod=(int)1e9+7;
        for(int i=0;i<q;i++){
            long product=1;
            for(int j=queries[i][0];j<=queries[i][1];j++){
                product=(product*power.get(j))%mod;
            }
            ans[i]=(int)product;
            
        }
        return ans;
    }
}