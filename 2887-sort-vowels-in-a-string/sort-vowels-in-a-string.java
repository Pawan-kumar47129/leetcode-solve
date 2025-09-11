class Solution {
    private boolean isVowel(char ch){
        if(ch=='a'||ch=='A' || ch=='e'||ch=='E'||ch=='i'||ch=='I'|| ch=='o'||ch=='O'||ch=='u'||ch=='U' )
            return true;
        return false;    
    }
    public String sortVowels(String s) {
        TreeMap<Character,Integer>map=new TreeMap<>((a,b)->a-b);
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(isVowel(ch)){
                map.put(ch,map.getOrDefault(ch,0)+1);
            }
        }
        StringBuilder result = new StringBuilder(s);
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(isVowel(ch)){
                char key=map.firstKey();
                int freq=map.get(key);
                result.setCharAt(i,key);
                if(freq==1){
                    map.remove(key);

                }else{
                    map.put(key,freq-1);
                }
            }
        }
        return result.toString();
    }
}