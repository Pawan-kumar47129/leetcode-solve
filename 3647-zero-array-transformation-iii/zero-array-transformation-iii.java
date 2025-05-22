class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        Arrays.sort(queries,(q1,q2)->q1[0]-q2[0]);
        int n=nums.length;
        PriorityQueue<int[]>queryHeap=new PriorityQueue<>((a,b)->b[1]-a[1]);//maxheap by ending
        PriorityQueue<int[]>pastQuery=new PriorityQueue<>((a,b)->a[1]-b[1]);//minheap by ending
        int operation=0;
        int j=0,q=queries.length;
        for(int i=0;i<n;i++){
            while(j<q && queries[j][0]==i){
                queryHeap.add(queries[j]);
                j++;
            }
            nums[i]-=pastQuery.size();
            while(nums[i]>0 && !queryHeap.isEmpty() && queryHeap.peek()[1]>=i){
                nums[i]--;
                pastQuery.add(queryHeap.poll());
                operation++;
            }
            if(nums[i]>0) return -1;
            while(!pastQuery.isEmpty() && pastQuery.peek()[1]<=i)pastQuery.poll();
        }
        return q-operation;
    }
}