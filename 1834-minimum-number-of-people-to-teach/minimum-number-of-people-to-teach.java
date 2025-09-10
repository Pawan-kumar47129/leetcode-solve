class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        //find bad user who doesnot able to talk 
        HashSet<Integer>badUser=new HashSet<Integer>();
        for(var friend:friendships){
            int u=friend[0]-1;
            int v=friend[1]-1;
            HashSet<Integer>langByU=new HashSet<>();
            for(int l:languages[u]){
                langByU.add(l);
            }
            boolean ableToTalk=false;
            for(int l:languages[v]){
                if(langByU.contains(l)){
                    ableToTalk=true;
                    break;
                }
            }
            if(!ableToTalk){
                badUser.add(u);
                badUser.add(v);
            }
        }
        //count language freq for each lang 
        int []freqLan=new int[n+1];
        int max=0;
        for(int u:badUser){
            for(int l:languages[u]){
                freqLan[l]++;
                max=Math.max(max,freqLan[l]);// count maxFreqLang  which lang most people know in badUser
            }
        } 
        return badUser.size()-max;
    }
}