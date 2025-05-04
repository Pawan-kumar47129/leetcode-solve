class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        HashMap<String,Integer>map=new HashMap<>();
        int ans=0;
        int n=dominoes.length;
        for(int  i=0;i<n;i++){
            int num1=dominoes[i][0],num2=dominoes[i][1];
            String key=num1<num2?num1+" "+num2:num2+" "+num1;
            int count=map.getOrDefault(key,0);
            ans+=count;
            map.put(key,count+1);
        }
        return ans;
    }
}