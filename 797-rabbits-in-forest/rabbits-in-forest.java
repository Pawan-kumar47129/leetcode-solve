class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int n=answers.length;
        for(int i=0;i<n;i++){
            map.put(answers[i],map.getOrDefault(answers[i],0)+1);
        }
        int ans=0;
        for(Map.Entry<Integer,Integer>pair:map.entrySet()){
            int color=pair.getKey();
            int value=pair.getValue();
            int total=value/(color+1);
            ans+=total*(color+1);
            if(value%(color+1)!=0){
                ans+=color+1;
            }///example [2,2,2 ,2,2,2,  2]   every tell that anthor are same like me means total 3 rabit can tell this 2 other are same color but when 4 rabit tell 2 another are same color how is possible means 4 rabit are different color 
        }       //       red-3, blue-3, black-3
        return ans;
    }
}