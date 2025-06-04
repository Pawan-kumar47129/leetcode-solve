class Solution {
    public String answerString(String word, int numFriends) {
        int n=word.length();
        if(numFriends==1) return word;
        int size=n-numFriends+1;
        int maxIndex=0;
        for(int i=1;i<n;i++){
            if(word.charAt(maxIndex)<word.charAt(i)){
                maxIndex=i;
            }else if(word.charAt(maxIndex)==word.charAt(i)){
                for(int j=0;j+i<n && maxIndex+j<maxIndex+size;j++){
                    if(word.charAt(maxIndex+j)<word.charAt(i+j)){
                        maxIndex=i;
                        break;
                    }else if(word.charAt(maxIndex+j)>word.charAt(i+j)) break;
                }
            }
        }
        if((maxIndex+size) <= n) return word.substring(maxIndex,maxIndex+size);
        return word.substring(maxIndex,n);
    }
}