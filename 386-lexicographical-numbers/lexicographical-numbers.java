class Solution {
    private void func(int currNum,int n,List<Integer>ans){
        if(currNum>n) return ;
        if(currNum<=n && currNum!=0) {
            ans.add(currNum);
        }
        for(int i=0;i<=9;i++){
            if(currNum==0 && i==0) continue;
            func(currNum*10+i,n,ans);
        }
    }
    public List<Integer> lexicalOrder(int n) {
       List<Integer> ans=new ArrayList<>(n);
       func(0,n,ans);
       return ans;
    }
}