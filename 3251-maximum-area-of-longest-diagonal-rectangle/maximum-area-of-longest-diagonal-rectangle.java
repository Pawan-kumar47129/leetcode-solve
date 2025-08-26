class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int ans=0,n=dimensions.length;
        double dia=0.0;
        for(int i=0;i<n;i++){
            int length=dimensions[i][0];
            int width=dimensions[i][1];
            double d=Math.sqrt((length*length)+(width*width));
            if(d>dia){
                dia=d;
                ans=length*width;
            }else if(d==dia){
                ans=Math.max(ans,length*width);
            }
        }
        return ans;
    }
}