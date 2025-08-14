class Solution {
    public String largestGoodInteger(String num) {
        int i=0,j=1,k=2;
        char ans='/';
        while(k<num.length()){
            if(num.charAt(i)==num.charAt(j) && num.charAt(k)==num.charAt(i)){
                if(ans<num.charAt(i)) ans=num.charAt(i);
            }
            i++;j++;k++;
        }
        if(ans=='/') return "";
        return ""+ans+ans+ans;
    }
}