class Solution {
    private String changeOddIndexValue(String s,int a){
        StringBuilder str=new StringBuilder(s);
        for(int i=0;i<str.length();i++){
            if(i%2==1){
                char ch= (char)((((str.charAt(i)-'0') + a)%10)+'0');
                str.setCharAt(i,ch);
            }
        }
        return str.toString();
    }
    private String rotateString(String s,int b){
        int n=s.length();
        b=b%n;
        char[]charArr=s.toCharArray();
        reverseString(charArr,0,n-1);
        reverseString(charArr,0,b-1);
        reverseString(charArr,b,n-1);
        return String.valueOf(charArr);
    }
    private void reverseString(char[]arr,int low,int high){
        while(low<high){
            char temp=arr[low];
            arr[low]=arr[high];
            arr[high]=temp;
            low++;
            high--;
        }
    }
    public String findLexSmallestString(String s, int a, int b) {
        String ans=s;
        Queue<String>queue=new LinkedList<>();
        queue.add(s);
        HashSet<String>visited=new HashSet<>();
        while(!queue.isEmpty()){
            String curr=queue.poll();
            if(curr.compareTo(ans)<0){
                ans=curr;
            }
            String changeIdxString=changeOddIndexValue(curr,a);
            if(!visited.contains(changeIdxString)){
                queue.add(changeIdxString);
                visited.add(changeIdxString);
            }
            String rotateStr=rotateString(curr,b);
            if(!visited.contains(rotateStr)){
                queue.add(rotateStr);
                visited.add(rotateStr);
            }

        }
        return ans;
    }
}