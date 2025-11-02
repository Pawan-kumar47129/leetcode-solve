class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][]ans=new int[m][n];
        for(int i=0;i<walls.length;i++){
            ans[walls[i][0]][walls[i][1]]=1;
        }
        for(int i=0;i<guards.length;i++){
            ans[guards[i][0]][guards[i][1]]=1;
        }    
        for(int i=0;i<guards.length;i++){
            int row=guards[i][0],col=guards[i][1];
            //check left
            for(int j=col-1;j>=0;j--){
                if(ans[row][j]==1){
                    break;
                }else{
                    ans[row][j]=2;
                }
            }
            //check right
            for(int j=col+1;j<n;j++){
                if(ans[row][j]==1){
                    break;
                }else{
                    ans[row][j]=2;
                }
            }
            //check up
            for(int j=row-1;j>=0;j--){
                if(ans[j][col]==1){
                    break;
                }else{
                    ans[j][col]=2;
                }
            }
            //check down
            for(int j=row+1;j<m;j++){
                if(ans[j][col]==1){
                    break;
                }else{
                    ans[j][col]=2;
                }
            }
        }
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(ans[i][j]==0){
                    count++;
                }
            }
        }
        return count;
    }
}