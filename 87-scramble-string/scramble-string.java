class Solution {
    HashMap<String,Boolean>memo;
    private boolean helper(String s1,String s2){
        String key = s1 + "_" + s2;
        if (memo.containsKey(key)) return memo.get(key);
        if (s1.equals(s2)) {
            memo.put(key, true);
            return true;
        }
        if(s1.length()==1) {
            memo.put(key,false);
            return false;
        }    
        for(int len=1;len<s1.length();len++){
            //not swap
            boolean notSwap=helper(s1.substring(0,len),s2.substring(0,len)) &&
                            helper(s1.substring(len),s2.substring(len));
            if(notSwap) {
                memo.put(key,true);
                return true;
            }
            boolean swap=helper(s1.substring(0,len),s2.substring(s2.length()-len)) &&
                        helper(s1.substring(len),s2.substring(0,s2.length()-len));  
            if(swap) {
                memo.put(key,true);
                return true;
            }                      
        }
        memo.put(key,false);
        return false;
    }
    public boolean isScramble(String s1, String s2) {
        memo=new HashMap<>();
        return helper(s1,s2);
    }
}