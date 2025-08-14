class Solution {
    public String largestGoodInteger(String num) {
        int i=0,j=1,k=2;
        char ans='\0';
        while(k<num.length()){
            if(num.charAt(i)==num.charAt(j) && num.charAt(k)==num.charAt(i)){
                if(ans<num.charAt(i)) ans=num.charAt(i);
            }
            i++;j++;k++;
        }
        if(ans=='\0') return "";
        return new String(new char[]{ans,ans,ans});
    }
}