class Solution {
    public String robotWithString(String s) {
        int n=s.length();
        StringBuilder ans=new StringBuilder(n);
        StringBuilder t=new StringBuilder(n);
        char[]rightMin=new char[n];
        rightMin[n-1]=s.charAt(n-1);
        for(int i=n-2;i>=0;i--){
            rightMin[i]=s.charAt(i)>rightMin[i+1]?rightMin[i+1]:s.charAt(i);
        }
        for(int i=0;i<n;i++){
            while(t.length()>0 && t.charAt(t.length()-1)<=rightMin[i]){
                ans.append(t.charAt(t.length()-1));
                t.deleteCharAt(t.length()-1);
            }
            t.append(s.charAt(i));
        }
        while( t.length()>0){
            ans.append(t.charAt(t.length()-1));
            t.deleteCharAt(t.length()-1);
        }
        return ans.toString();
    }
}