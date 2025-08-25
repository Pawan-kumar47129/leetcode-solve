class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int i=0;
        int j=0;
        int[]ans=new int[n*m];
        int idx=0;
        int dir=1;//1-up 0=down 
        while(true){
            if(dir==1){
                while(i>=0 && j<m){
                    ans[idx++]=mat[i][j];
                    i--;
                    j++;
                }
                i++;
                if(j==m){
                    i++;
                    j--;
                }
                dir=0;
            }else{
                while(j>=0 && i<n){
                    ans[idx++]=mat[i][j];
                    i++;
                    j--;
                }
                j++;
                if(i==n){
                    j++;
                    i--;
                }
                dir=1;
            }
            if(idx==n*m) break;
        }
        return ans;
    }
}