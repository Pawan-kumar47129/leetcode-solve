class Solution {
    public int minJumps(int[] nums) {
        int n=nums.length;
        HashMap<Integer,List<Integer>>indexMap=new HashMap<>();
        for(int i=0;i<n;i++){
            indexMap.putIfAbsent(nums[i],new ArrayList<>());
            indexMap.get(nums[i]).add(i);
        }
        boolean[]visited=new boolean[n];
        Queue<Integer>queue=new LinkedList<>();
        queue.add(0);
        visited[0]=true;
        int steps=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                int index=queue.poll();
                if(index==n-1) return steps;
                if(index-1>=0 && !visited[index-1]){
                    queue.add(index-1);
                    visited[index-1]=true;
                }
                if(index+1<n && !visited[index+1]){
                    queue.add(index+1);
                }
                List<Integer>list=indexMap.get(nums[index]);
                if(list==null) continue;
                for(var ele:list){
                    if(!visited[ele]){
                        queue.add(ele);
                        visited[ele]=true;
                    }
                }
                indexMap.remove(nums[index]);//remove because next time not run again becuase we already pushed all same element in queue   
            }
            steps++;
        }
        return steps;
    }
}