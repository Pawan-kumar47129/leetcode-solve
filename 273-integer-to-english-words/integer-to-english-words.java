class Solution {
    public String numberToWords(int num) {
        Map<Integer, String> map = new HashMap<>() {
            {
                put(1, "One");
                put(2, "Two");
                put(3, "Three");
                put(4, "Four");
                put(5, "Five");
                put(6, "Six");
                put(7, "Seven");
                put(8, "Eight");
                put(9, "Nine");
                put(10, "Ten");
                put(11, "Eleven");
                put(12, "Twelve");
                put(13, "Thirteen");
                put(14, "Fourteen");
                put(15, "Fifteen");
                put(16, "Sixteen");
                put(17, "Seventeen");
                put(18, "Eighteen");
                put(19, "Nineteen");
                put(20, "Twenty");
                put(30, "Thirty");
                put(40, "Forty");
                put(50, "Fifty");
                put(60, "Sixty");
                put(70, "Seventy");
                put(80, "Eighty");
                put(90, "Ninety");
                put(100, "Hundred");
                put(1000, "Thousand");
                put(1000000, "Million");
                put(1000000000, "Billion");
            }
        };
        if(num==0) return "Zero";
        String []unit={"Thousand","Million","Billion","Trillion"};
        String numStr=Integer.toString(num);
        int n=numStr.length()/3+(numStr.length()%3==0?0:1);
        int[]arr=new int[n];
        StringBuilder str=new StringBuilder(numStr);
        int index=n-1;
        while(str.length()>0){
            int len=str.length();
            int startIndex=Math.max(len-3,0);
            arr[index--]=Integer.parseInt(str.substring(startIndex));
            str.delete(startIndex,len);
        }
        StringBuilder ans=new StringBuilder();
        index=n-2;
        for(int i=0;i<n;i++){
            int curr=arr[i];
            int base=100;
            boolean flag=false;
            while(curr>0){
                int digit=curr/base;
                    if(curr<=20) {
                        ans.append(" "+map.get(curr));
                        flag=true;
                        break;
                    }
                    if(digit>0){
                        if(base<=10)ans.append(" "+map.get(digit*base));
                        else ans.append(" "+ map.get(digit)).append(" "+map.get(100));
                        flag=true;
                }
                curr=curr%base;
                base/=10;
            }
            if(index>=0 && flag)ans.append(" "+ unit[index]);
            index--;
        }
        ans.deleteCharAt(0);
        return ans.toString();
    }
}