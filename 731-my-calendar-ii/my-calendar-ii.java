class MyCalendarTwo {
    Map<Integer,Integer>diffArray;
    public MyCalendarTwo() {
        diffArray=new TreeMap<>();
    }
    
    public boolean book(int startTime, int endTime) {
        diffArray.put(startTime,diffArray.getOrDefault(startTime,0)+1);
        diffArray.put(endTime,diffArray.getOrDefault(endTime,0)-1);
        int sum=0;
        for(int value:diffArray.values()){
            sum+=value;
            if(sum>=3){
                diffArray.put(startTime,diffArray.get(startTime)-1);
                diffArray.put(endTime,diffArray.get(endTime)+1);
                return false;
            }
        }
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */