class Solution {
    public int maxDiff(int num) {
        String str=Integer.toString(num);
        int pos=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)<'9'){
                pos=i;
                break;
            }
        }
        int maxNum=Integer.parseInt(str.replace(str.charAt(pos),'9'));
        int i=0;
        while(i<str.length() && (str.charAt(i)=='1' || str.charAt(i)=='0')){
            i++;
        }
        int minNum=num;
        if(i!=str.length()){
            if(i==0) minNum=Integer.parseInt(str.replace(str.charAt(0),'1'));
            else minNum=Integer.parseInt(str.replace(str.charAt(i),'0'));
        } 
        return maxNum-minNum;
    }
}