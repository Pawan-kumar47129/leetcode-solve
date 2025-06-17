class Solution {
    public int totalFruit(int[] fruits) {
        int lastIndexForSameElement=0;
        int basket1=fruits[0];
        int basket2=-1;
        int ans=1,n=fruits.length;
        int currentCount=1;
        for(int i=1;i<n;i++){
            if(fruits[i]==basket1 || fruits[i]==basket2){
                currentCount++;
                if(fruits[lastIndexForSameElement]!=fruits[i]){
                    lastIndexForSameElement=i;
                }
            }else if(basket2==-1){
                currentCount++;
                basket2=fruits[i];
                lastIndexForSameElement=i;
            }else{
                ans=Math.max(ans,currentCount);
                currentCount=i-lastIndexForSameElement;//prev element ka count so we take that element as in first backet
                basket1=fruits[lastIndexForSameElement];
                basket2=fruits[i];
                lastIndexForSameElement=i;
                currentCount++;// this count increase for current basket2
            }
        }
        ans=Math.max(ans,currentCount);
        return ans;
    }
}