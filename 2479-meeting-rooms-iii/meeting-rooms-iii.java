class Solution {
    private void givesRoomForMeeting(int[]meeting,long[][]room){
        int n=room.length;
        long minTime=Long.MAX_VALUE;
        int roomId=-1;
        for(int i=0;i<n;i++){
            if(room[i][0]<=meeting[0]){
                minTime=room[i][0]*1l;
                roomId=i;
                break;
            }else{
                if(minTime>room[i][0]){
                    minTime=room[i][0]*1l;
                    roomId=i;
                }
            }
        }
        if(room[roomId][0]<=meeting[0]){
            room[roomId][0]=meeting[1]*1l;
            room[roomId][1]++;
        }else{
            room[roomId][0]=meeting[1]*1l+(room[roomId][0]-meeting[0]);
            room[roomId][1]++;
        }
    }
    public int mostBooked(int n, int[][] meetings) {
        long [][]room=new long[n][2];
        int len=meetings.length;
        Arrays.sort(meetings,(a,b)->a[0]-b[0]);
        int time=0;
        for(int i=0;i<len;i++){
            givesRoomForMeeting(meetings[i],room);
        }
        long maxCount=0;
        int roomId=0;
        for(int i=0;i<n;i++){
            if(room[i][1]>maxCount){
                maxCount=room[i][1];
                roomId=i;
            }
        }
        return roomId;
    }
}