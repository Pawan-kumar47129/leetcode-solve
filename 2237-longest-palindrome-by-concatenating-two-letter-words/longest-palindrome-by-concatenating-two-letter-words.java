class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String,Integer>map=new HashMap<>();
        int result=0;
        for(int i=0;i<words.length;i++){
            String rev=""+words[i].charAt(1)+words[i].charAt(0);
            if(map.getOrDefault(rev,0)>0){
                result+=4;
                map.put(rev,map.getOrDefault(rev,0)-1);
            }else{
                map.put(words[i],map.getOrDefault(words[i],0)+1);
            }
        }
        for(var ele:map.entrySet()){// same character at middle we add
            String key=ele.getKey();
            int count=ele.getValue();
            if(key.charAt(0)==key.charAt(1) && count>0){
                result+=2;
                break;
            }
        }
        return result;
    }
}