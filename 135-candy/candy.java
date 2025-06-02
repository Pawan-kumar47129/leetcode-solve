class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int[]left=new int[n];
        int[]right=new int[n];
        left[0]=1;
        right[n-1]=1;
        for(int i=1;i<n;i++){
            if(ratings[i-1]<ratings[i]){
                left[i]=left[i-1]+1;
            }else{
                left[i]=1;
            }
            if(ratings[n-1-i]>ratings[n-i]){
                right[n-1-i]=right[n-i]+1;
            }else{
                right[n-1-i]=1;
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=Math.max(left[i],right[i]);
        }
        return ans;
    }
}