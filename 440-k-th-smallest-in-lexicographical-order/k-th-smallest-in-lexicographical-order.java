/*class Solution {
    int dfs(int currNum,int n,int []k){
        if(currNum>n) {
            k[0]++;
            return -1;
        }
        if(k[0]==0) return currNum;
        for(int i=0;i<=9;i++){
            if(currNum==0 && i==0) continue;
            int nextNum=currNum*10+i;
            k[0]--;
            int ans=dfs(nextNum,n,k);
            if(ans!=-1) return ans;
        }
        return -1;
    }
    public int findKthNumber(int n, int k) {
        int count[]={k};
        return dfs(0,n,count);
    }
}*/

class Solution {
    int dfs(int currNum,int n,int []k){
        if(currNum>n) {
            k[0]++;
            return -1;
        }
        if(k[0]==0) return currNum;
        for(int i=0;i<=9;i++){
            if(currNum==0 && i==0) continue;
            int nextNum=currNum*10+i;
            k[0]--;
            int ans=dfs(nextNum,n,k);
            if(ans!=-1) return ans;
        }
        return -1;
    }
    private int countNumberBetween(long curr,long next,int n){
        int countNum=0;
        while(curr<=n){
            countNum+=next-curr;
            curr=curr*10;
            next=Math.min(next*10,(long)n+1);
        }
        return countNum;
    }
    public int findKthNumber(int n, int k) {
        long currNum=1;
        k-=1;//for 1 
        while(k>0){
            int countNum=countNumberBetween(currNum,currNum+1,n);
            if(countNum<=k){
                k-=countNum;
                currNum++;
            }else{
                currNum*=10;
                k-=1;
            }
        }
        return (int)currNum;
    }
}