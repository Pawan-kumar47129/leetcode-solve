class Solution {
    public String makeFancyString(String s) {
        StringBuilder ans=new StringBuilder();
        int freqCount=0;
        for(int i=0;i<s.length();i++){
            if(ans.isEmpty() || ans.charAt(ans.length()-1)!=s.charAt(i)){
                ans.append(s.charAt(i));
                freqCount=1;
            }else if(freqCount<2){
                ans.append(s.charAt(i));
                freqCount++;
            }else{
                while(i<s.length() && ans.charAt(ans.length()-1)==s.charAt(i)){
                    i++;
                }
                if(i<s.length()){
                    ans.append(s.charAt(i));
                    freqCount=1;
                }
            }
        }
        return ans.toString();
    }
}