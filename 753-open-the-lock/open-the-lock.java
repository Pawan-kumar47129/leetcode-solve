class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String>deadSet=new HashSet<>();
        for (var str:deadends){
            deadSet.add(str);
        }
        Queue<String>queue=new LinkedList<>();
        if(!deadSet.contains("0000")){
            queue.add("0000");
            deadSet.add("0000");
        }    
        int ans=0;
        while(!queue.isEmpty()){
            int n=queue.size();
            for(int i=0;i<n;i++){
                String curr=queue.poll();
                if(curr.equals(target)) return ans;
                char[]charArr=curr.toCharArray();
                for(int d=0;d<4;d++){
                    char ch=charArr[d];
                    //increase
                    charArr[d]=(char)(((ch-'0'+1)%10)+'0');
                    String newStr=String.valueOf(charArr);
                    if(!deadSet.contains(newStr)){
                        queue.add(newStr);
                        deadSet.add(newStr);
                    }
                    // decrease
                    charArr[d]=(char)(((ch-'0'-1+10)%10)+'0');
                    String dStr=String.valueOf(charArr);
                    if(!deadSet.contains(dStr)){
                        queue.add(dStr);
                        deadSet.add(dStr);
                    }
                    charArr[d]=ch;
                }
            }
            ans++;

        }
        return -1;
    }
}