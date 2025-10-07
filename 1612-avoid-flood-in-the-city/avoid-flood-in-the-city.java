class Solution {
    public int[] avoidFlood(int[] rains) {
        HashMap<Integer,Integer>map=new HashMap<>();// track the lack where rained in which day
        TreeSet<Integer>set=new TreeSet<>();//track the empty day mean rain not happend in that day
        int n=rains.length;
        int[]ans=new int[n];
        for(int i=0;i<n;i++){
            if(rains[i]>0){
                ans[i]=-1;
                int day=map.getOrDefault(rains[i],-1);// which day early rain heppend
                if(day!=-1){
                    Integer emptyDay=set.higher(day);//finding first not raining day
                    if(emptyDay==null) return new int[0];//food happend
                    else{
                        ans[emptyDay]=rains[i];//try this lake on that emptyDay
                        map.put(rains[i],i);
                        set.remove(emptyDay);
                    }
                }else {
                    map.put(rains[i],i);
                }
            }else{
                set.add(i);
                ans[i]=1;// setting defualt
            }

        }
        return ans;

    }
}