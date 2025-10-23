class Solution {
    public boolean hasSameDigits(String s) {
        while(s.length()>2){
            StringBuilder str=new StringBuilder();
            for(int i=1;i<s.length();i++){
                char ch=(char)(((s.charAt(i-1) - '0' + s.charAt(i)-'0')%10) +'0');
                str.append(ch);
            }
            s=str.toString();
        }
        return s.charAt(0)==s.charAt(1);
    }
}