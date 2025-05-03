class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n=tops.length;
        int bSwap=0;
        boolean isBottomPossible=true;
        int tSwap=0;
        boolean isTopPossible=true;
        // first element top ko bottom par rak kar deko
        int tbSwap=1;
        boolean istbPossible=true;
        int btSwap=1;// frist bottom ko top par rak ker deko
        boolean isbtPossible=true;
        for(int i=1;i<n;i++){
            if(isTopPossible){
                if(tops[0]!=tops[i] && tops[0]!=bottoms[i]){
                    isTopPossible=false;
                }else if(tops[0]!=tops[i]) tSwap++;
            }
            if(isBottomPossible){
                if(bottoms[0]!=bottoms[i] && bottoms[0]!=tops[i]){
                    isBottomPossible=false;
                }else if(bottoms[0]!=bottoms[i]){
                    bSwap++;
                }
            }
            if(istbPossible){
                if(tops[0]!=bottoms[i] && tops[0]!=tops[i]){
                    istbPossible=false;
                }else if(tops[0]!=bottoms[i]) tbSwap++;
            }
            if(isbtPossible){
                if(bottoms[0]!=bottoms[i] && bottoms[0]!=tops[i]){
                    isbtPossible=false;
                }else if(bottoms[0]!=tops[i]) btSwap++;
            }
        }
        if(!isBottomPossible && !isTopPossible && !istbPossible && !isbtPossible) return -1;
        int min=n;
        if(isBottomPossible) min=Math.min(min,bSwap);
        if(isTopPossible) min=Math.min(min,tSwap);
        if(istbPossible) min=Math.min(min,tbSwap);
        if(isbtPossible) min=Math.min(min,btSwap);
        return min;
    }
}