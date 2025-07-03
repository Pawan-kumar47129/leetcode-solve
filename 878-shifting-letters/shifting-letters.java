class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        StringBuilder result=new StringBuilder(s);
        int n=shifts.length;
        for(int i=n-1;i>=0;i--){
            if(i<n-1)shifts[i]=(shifts[i]%26+shifts[i+1]%26)%26;

            char ch=s.charAt(i);
            int next=(ch-'a'+shifts[i])%26;
            char nextChar=(char)(next + 'a');
            result.setCharAt(i,nextChar);
        }
        return result.toString();
    }
}