// gready approch fail
/*class Solution {
    public int maxCollectedFruits(int[][] fruits) {
        int ans=0;
        int n=fruits.length;
        for(int i=0;i<n;i++){
            ans+=fruits[i][i];
            fruits[i][i]=0;
        }
        int i=0,j=n-1;
        ans+=fruits[i][j];
        fruits[i][j]=0;

        while(i<n-1 && j<n){
            if(j==n-1){
                if(fruits[i+1][j-1]>fruits[i+1][j]){
                    ans+=fruits[i+1][j-1];
                    fruits[i+1][j-1]=0;
                    i++;j--;
                }else{
                    ans+=fruits[i+1][j];
                    fruits[i+1][j]=0;
                    i++;
                }
            }else{
                if(fruits[i+1][j+1]>fruits[i+1][j]){
                    ans+=fruits[i+1][j+1];
                    fruits[i+1][j+1]=0;
                    i++;j++;
                }else{
                    ans+=fruits[i+1][j];
                    fruits[i+1][j]=0;
                    i++;
                }
            }
        }
        i=n-1;j=0;
        ans+=fruits[i][j];
        while(i<n && j<n-1){
            if(i==n-1){
                if(fruits[i][j+1]>fruits[i-1][j+1]){
                    ans+=fruits[i][j+1];
                    j++;
                }else{
                    ans+=fruits[i-1][j+1];
                    i--;
                    j++;
                }
            }else{
                if(fruits[i+1][j+1]>fruits[i][j+1]){
                    ans+=fruits[i+1][j+1];
                    j++;
                    i++;
                }else{
                    ans+=fruits[i][j+1];
                    j++;
                }
            }
        }
        return ans;
    }
}*/

class Solution {
    int n;
    private int secondChild(int i,int j,int[][]fruits,Integer[][]memo){
       if(i>j || i<0 ||i>=n ||j<0 || j>=n) return Integer.MIN_VALUE;
       if(i==n-1 && j==n-1) return 0;
       if(memo[i][j]!=null) return memo[i][j];
       int choice1=secondChild(i+1,j-1,fruits,memo);
       int choice2=secondChild(i+1,j,fruits,memo);
       int choice3=secondChild(i+1,j+1,fruits,memo);
       return memo[i][j]=Math.max(choice1,Math.max(choice2,choice3))+fruits[i][j];
    }
    private int thirdChild(int i,int j,int[][]fruits,Integer[][]memo){
       if(i<j || i<0 ||i>=n ||j<0 ||  j>=n) return Integer.MIN_VALUE;
       if(i==n-1 && j==n-1) return 0;
       if(memo[i][j]!=null) return memo[i][j];
       int choice1=thirdChild(i-1,j+1,fruits,memo);
       int choice2=thirdChild(i,j+1,fruits,memo);
       int choice3=thirdChild(i+1,j+1,fruits,memo);
       return memo[i][j]=Math.max(choice1,Math.max(choice2,choice3))+fruits[i][j];
    }
    public int maxCollectedFruits(int[][] fruits) {
        int ans=0;
        n=fruits.length;
        //for first child
        for(int i=0;i<n;i++){
            ans+=fruits[i][i];
            fruits[i][i]=0;
        }
        /// for second child
        Integer[][]memo=new Integer[n][n];
        ans+=secondChild(0,n-1,fruits,memo);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                memo[i][j]=null;
            }
        }
        ans+=thirdChild(n-1,0,fruits,memo);
        return ans;
    }
}
