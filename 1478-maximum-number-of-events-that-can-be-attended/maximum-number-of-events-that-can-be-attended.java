class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events,(a,b)->a[0]-b[0]);

        //attend events as much much last if possible
        int maxDay=0;
        int n=events.length;
        for(int i=0;i<n;i++){
            maxDay=Math.max(maxDay,events[i][1]);
        }
        //try each day attend meeting if one day there are more than 1 event available then do that event which has less endTime
        PriorityQueue<Integer>queue=new PriorityQueue<>();//handle that which event we need to do on ith day
        int ans=0;
        for(int i=1,j=0;i<=maxDay;i++){
            while(j<n && events[j][0]<=i)//can we do on ith day
            {
                queue.add(events[j][1]);//maintain only endTime mean which on less can do that event on ith day
                j++;
            }
            while(!queue.isEmpty() && queue.peek()<i)// this not able to attends because the time is over
            {
                queue.poll();
            }
            if(!queue.isEmpty()){
                ans++;
                queue.poll();// this event is done on ith day
            }
        }
        return ans;
    }
}