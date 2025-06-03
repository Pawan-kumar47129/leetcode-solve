class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n=status.length;
        Queue<Integer>queue=new LinkedList<>();
        boolean visited[]=new boolean[n];
        HashSet<Integer>pelding=new HashSet<>();
        for(int box:initialBoxes){
            queue.add(box);
            visited[box]=true;
        }
        int ans=0;
        while(!queue.isEmpty()){
            int currBox=queue.poll();
            if(status[currBox]==0) {
                pelding.add(currBox);
                continue;
            }
            ans+=candies[currBox];
            candies[currBox]=0;
            for(int boxes:containedBoxes[currBox]){
                if(!visited[boxes]){
                    queue.add(boxes);
                    visited[boxes]=true;
                }
            }
            for(int key:keys[currBox]){
                status[key]=1;
                if(pelding.contains(key)){
                    queue.add(key);
                    pelding.remove(key);
                }
            }
        }
        return ans;
    }
}