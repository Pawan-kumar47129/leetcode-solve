class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        //find total freq of each character
        int[] totalFreq = new int[26];
        for (char ch : s.toCharArray()) {
            totalFreq[ch - 'a']++;
        }
        int startIdx=0;
        int[]leftFreq=new int[26];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            leftFreq[ch-'a']++;
            boolean flag=true;
            //try partition at index i
            for(int j=0;j<26;j++){
                //till ith ,freq of all character can able to make 0 of total freq of each character which are present till ith index in string
                if(leftFreq[j]!=0 && totalFreq[j]-leftFreq[j]!=0){
                    flag=false;
                    break;
                }
            }
            if(flag){
                ans.add(i-startIdx+1);
                startIdx=i+1;//next patrition start at next index
            }
        }
        return ans;
    }
}