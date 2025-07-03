class Solution {
    public long shiftDistance(String s, String t, int[] nextCost, int[] prevCost) {
        //preCompute prefix sum
        long[]prefixNext=new long[26];
        long[]prefixPrev=new long[26];
        prefixNext[0]=nextCost[0];
        prefixPrev[25]=prevCost[25];
        for(int i=1;i<26;i++){
            prefixNext[i]=nextCost[i]+prefixNext[i-1];
            prefixPrev[25-i]=prevCost[25-i]+prefixPrev[26-i];
        }
        long ans=0;
        for(int i=0;i<s.length();i++){
            char origin=s.charAt(i);
            char change=t.charAt(i);
            if(origin==change) continue;
            // try to next
            long temp1=0;
            if(origin<change){
                temp1=prefixNext[change-'a'-1];
                if(origin!='a') temp1-=prefixNext[origin-'a'-1];
            }else{
                temp1=prefixNext[25]-prefixNext[origin-'a'-1];
                if(change>'a'){
                    temp1+=prefixNext[change-'a'-1];
                }
            }
            //try through prev
            long temp2=0;
            if(origin>change){
                temp2=prefixPrev[change-'a'+1];
                if(origin!='z') temp2-=prefixPrev[origin-'a'+1];
            }else{
                temp2=prefixPrev[0]-prefixPrev[origin-'a'+1];//go to 'z'
                if(change!='z'){
                    temp2+=prefixPrev[change-'a'+1];
                }
            }
            ans+=Math.min(temp1,temp2);
        }
        return ans;
    }
}