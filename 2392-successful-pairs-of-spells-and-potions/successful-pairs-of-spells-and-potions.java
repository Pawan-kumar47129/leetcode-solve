class Solution {
    int lowerBound(int []potions,long x){
        int low=0;
        int high=potions.length-1;
        while(low<=high){//smallest index where potion[index]>=x
            int mid=low+(high-low)/2;
            if(potions[mid]>=x){//
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n=spells.length;
        int m=potions.length;
        int[]ans=new int[n];
        for(int i=0;i<n;i++){
            long x=(long)Math.ceil(success/(double)spells[i]);
            int lowerIndex=lowerBound(potions,x);//here we find smallest index where potions[index]>=x; after that all element are greater so that would be also my ans 
            ans[i]=m-lowerIndex;
        }
        return ans;
    }
}