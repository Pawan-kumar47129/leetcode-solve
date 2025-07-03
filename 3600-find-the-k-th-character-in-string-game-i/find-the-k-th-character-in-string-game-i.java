class Solution {
    public char kthCharacter(int k) {
        StringBuilder result=new StringBuilder("a");
        result.append("b");
        while(result.length()<k){
            int right=result.length()/2;
            StringBuilder next=new StringBuilder(result.substring(right));
            for(int i=right;i<result.length();i++){
                int nextCharInt=((result.charAt(i)-'a')+1)%26;
                char nextChar=(char)('a'+nextCharInt);
                next.append(nextChar);
            }
            result.append(next);
        }
        return result.charAt(k-1);
    }
}