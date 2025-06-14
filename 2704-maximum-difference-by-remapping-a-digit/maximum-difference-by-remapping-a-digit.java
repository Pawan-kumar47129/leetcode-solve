class Solution {
    public int minMaxDifference(int num) {
        StringBuilder str=new StringBuilder();
        str.append(num);
        int changeDigit=-1;
        for(int i=0;i<str.length();i++){
            if(changeDigit==-1 && str.charAt(i)<'9'){
                changeDigit=str.charAt(i)-'0';
                str.setCharAt(i,'9');
            }else if(str.charAt(i)==(char)('0'+changeDigit)){
                str.setCharAt(i,'9');
            }
        }
        int maxNum=Integer.parseInt(str.toString());
        changeDigit=-1;
        str.setLength(0);
        str.append(num);
        for(int i=0;i<str.length();i++){
            if(changeDigit==-1 && str.charAt(i)>'0'){
                changeDigit=str.charAt(i)-'0';
                str.setCharAt(i,'0');
            }else if(str.charAt(i)==(char)('0'+ changeDigit)){
                str.setCharAt(i,'0');
            }
        }
        int minNum=Integer.parseInt(str.toString());
        return maxNum-minNum;

    }
}