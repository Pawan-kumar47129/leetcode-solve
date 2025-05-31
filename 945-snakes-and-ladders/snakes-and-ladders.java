class Solution {
    int[] getCellIndex(int nums,int n){
        nums=nums-1;
        int topRow=nums/n;
        int col=nums%n;
        int bottomRow=n-1-topRow;
        if((bottomRow%2==0 && n%2==0)||(bottomRow%2==1 && n%2==1)){
            col=n-1-col;
        }
        return new int[]{bottomRow,col};

    }
    public int snakesAndLadders(int[][] board) {
        int step=0;
        int n=board.length;
        boolean [][]visited=new boolean[n][n];
        Queue<Integer>queue=new LinkedList<>();
        queue.add(1);
        visited[n-1][0]=true;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                int node=queue.poll();
                if(node==n*n) return step;
                for(int k=1;k<=6;k++){
                    int nextNum=node+k;
                    if(nextNum>n*n) break;
                    int []cell=getCellIndex(nextNum,n);
                    int row=cell[0];
                    int col=cell[1];
                    if(!visited[row][col]){
                        visited[row][col]=true;
                        if(board[row][col]!=-1){
                            queue.add(board[row][col]);
                        }
                        else{
                            queue.add(nextNum);
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}