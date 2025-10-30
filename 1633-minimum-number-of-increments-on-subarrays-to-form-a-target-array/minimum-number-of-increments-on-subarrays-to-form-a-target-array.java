class Solution {
    public int minNumberOperations(int[] target) {
        int operation=0;
        int prev=0;
        for(int i=0;i<target.length;i++){
            int curr=target[i];
            if(prev<curr){
                operation+=curr-prev;
            }
            prev=curr;
        }
        return operation;
    }
}