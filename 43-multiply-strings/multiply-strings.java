class Solution {
    public String multiply(String num1, String num2) {
        int n1=num1.length();
        int n2=num2.length();
        StringBuilder ans=new StringBuilder(n1+n2);
        for(int i=0;i<n1+n2;i++){
            ans.append('0');
        }
        int stage=0;
        for(int i=n1-1;i>=0;i--){
            int carry=0,sumCarry=0,index=stage;
            int a=num1.charAt(i)-'0';
            for(int j=n2-1;j>=0;j--){
                int b=num2.charAt(j)-'0';
                int product=b*a+carry;
                int rem=product%10;
                carry=product/10;
                int sum=ans.charAt(index)-'0' + sumCarry+rem;
                char digit=(char)(sum%10+'0');
                ans.setCharAt(index,digit);
                sumCarry=sum/10;
                index++;
                if(index==ans.length()){
                    ans.append('0');
                }
            }
            if(sumCarry!=0 || carry!=0){
                char sum=(char)(sumCarry+carry+'0');
                ans.insert(index,sum);
            }
            stage++;
        }
        while(ans.length()>1 && ans.charAt(ans.length()-1)=='0') ans.deleteCharAt(ans.length()-1);
        return ans.reverse().toString();
    }
}