class Solution {
    public String clearStars(String s) {
        PriorityQueue<int[]>queue=new PriorityQueue<>((a,b)->{
            if(a[0]==b[0])
                return b[1]-a[1];
            return a[0]-b[0];    
        });
        int n=s.length();
        HashSet<Integer>deleteIndex=new HashSet<>();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='*'){
                int curr[]=queue.poll();
                deleteIndex.add(curr[1]);
            }else{
                queue.add(new int[]{s.charAt(i)-'a',i});
            }
        }
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<n;i++){
            if(s.charAt(i)!='*' && !deleteIndex.contains(i)){
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }
}