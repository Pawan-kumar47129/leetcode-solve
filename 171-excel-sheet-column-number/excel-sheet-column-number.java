class Solution {
    public int titleToNumber(String columnTitle) {
        int ans=0;
        for(int i=0;i<columnTitle.length();i++){
            int charValue=columnTitle.charAt(i)-64;
            int value=ans*26+charValue;
            ans=value;
        }
        return ans;
    }
}