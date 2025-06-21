class Solution {
    private boolean func(int i,int j,String s,String p){
        if(i==0 && j==0) return true;
        if(j==0) return false;
        if(i==0){
            while(j>0){
                if(p.charAt(j-1)!='*') return false;
                j-=2;
            }
            return true;
        }
        if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.'){
            return func(i-1,j-1,s,p);
        }else if(p.charAt(j-1) == '*'){
                if(s.charAt(i-1)==p.charAt(j-2) || p.charAt(j-2)=='.'){
                    return func(i,j-2,s,p) || func(i-1,j,s,p);
                }
                else  return func(i,j-2,s,p);
        }
        else return false;
    }
    public boolean isMatch(String s, String p) {
        int n=s.length();
        int m=p.length();
        return func(n,m,s,p);
    }
}