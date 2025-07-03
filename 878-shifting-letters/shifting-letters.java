class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        StringBuilder result=new StringBuilder(s);
        int n=shifts.length;
        for(int i=n-2;i>=0;i--){
            shifts[i]=(shifts[i]%26+shifts[i+1]%26)%26;
        }
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            int next=(ch-'a'+shifts[i])%26;
            char nextChar=(char)(next + 'a');
            result.setCharAt(i,nextChar);
        }
        return result.toString();

    }
}