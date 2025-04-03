class Solution {
    int solve(int idx,char firstChar,char lastChar,String []words,Integer[][][]dp){
        if(idx>=words.length) return 0;
        if(dp[idx][firstChar-'a'][lastChar-'a']!=null) return dp[idx][firstChar-'a'][lastChar-'a'];
        char  currFirstChar=words[idx].charAt(0);
        char  currLastChar=words[idx].charAt(words[idx].length()-1);
        int   currLength=words[idx].length();
        //join(s,words[idx])
        int joinsLength1=currLength+solve(idx+1,firstChar,currLastChar,words,dp);
        if(lastChar==currFirstChar) joinsLength1--;

        //joins(words[idx],str)
        int joinsLength2=currLength+solve(idx+1,currFirstChar,lastChar,words,dp);
        if(currLastChar==firstChar) joinsLength2--;
        
        return dp[idx][firstChar-'a'][lastChar-'a']=Math.min(joinsLength1,joinsLength2);
    }

    public int minimizeConcatenatedLength(String[] words) {
        int length=words[0].length();
        char firstChar=words[0].charAt(0);
        char lastChar=words[0].charAt(length-1);
        Integer[][][] dp=new Integer[words.length][26][26];
        return length+solve(1,firstChar,lastChar,words,dp);
    }
}

