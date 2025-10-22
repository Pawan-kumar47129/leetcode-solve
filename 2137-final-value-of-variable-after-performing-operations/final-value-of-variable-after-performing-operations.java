class Solution {
    public int finalValueAfterOperations(String[] operations) {
        Map<String,Integer>map=Map.of(
            "++X",1,
            "--X",-1,
            "X++",1,
            "X--",-1
            );
        int x=0;    
        for(int i=0;i<operations.length;i++){
            x+=map.get(operations[i]);
        }
        return x;
    }
}