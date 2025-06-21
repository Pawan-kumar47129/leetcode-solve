class Solution {
    private int binarySearch(int low,int high,int[]freq,int key){
        while(low<=high){
            int mid=low+(high-low)/2;
            if(freq[mid]<=key){
                low=mid+1;
            }else high=mid-1;
        }
        return low;
    }
    public int minimumDeletions(String word, int k) {
        if(word.length()<=1)  return 0;
        int[]freq=new int[26];
        for(int i=0;i<word.length();i++){
            freq[word.charAt(i)-'a']++;
        }
        Arrays.sort(freq);
        int preSum[]=new int [26];
        int startIndex=0;
        preSum[0]=freq[0];
        for(int i=1;i<26;i++){
            if(freq[i]==0){
                startIndex=i;
            }else{
                preSum[i]+=freq[i]+preSum[i-1];
            }
        }
        int ans=Integer.MAX_VALUE;
        int prev=0;
        for(int i=startIndex;i<26;i++){
            int index=binarySearch(i+1,25,freq,freq[i]+k);// first element which greater than freq[i]+k
            int noOfGreaterElement=26-index;
            int sum=preSum[25]-preSum[index-1];
            int actualSum=noOfGreaterElement*(freq[i]+k);
            int remove=sum-actualSum;
            if(i>startIndex){
                prev=preSum[i-1];
            }
            ans=Math.min(ans,remove+prev);
        }
        return ans;
    }
}