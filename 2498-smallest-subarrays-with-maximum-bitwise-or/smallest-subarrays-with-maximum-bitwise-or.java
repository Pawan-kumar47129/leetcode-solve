/*
class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n=nums.length;
        int[]maxOr=new int[n];
        int or=0;
        for(int i=n-1;i>=0;i--){
            or|=nums[i];
            maxOr[i]=or;
        }
        int[]ans=new int[n];
        for(int i=0;i<n;i++){
            or=0;
            for(int j=i;j<n;j++){
                or|=nums[j];
                if(maxOr[i]==or){
                    ans[i]=j-i+1;
                    break;
                }
            }
        }
        return ans;
        
    }
}*/

class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n=nums.length;
        int[]maxOr=new int[n];
        int or=0;
        for(int i=n-1;i>=0;i--){
            or|=nums[i];
            maxOr[i]=or;
        }
        int[]ans=new int[n];
        int[]pos=new int[31];
        int left=0;
        int right=0;
        int currOr=0;
        while(right<n){
            for(int bit=0;bit<31;bit++){
                if((nums[right] & (1<<bit))>0){// store in pos for each setbit count
                    pos[bit]++;
                    if(pos[bit]==1)
                        currOr+=(1<<bit);
                }
            }
            while(left<=right && currOr==maxOr[left]){
                ans[left]=right-left+1;
                for(int bit=0;bit<31;bit++){
                    if((nums[left] & (1<<bit))>0){
                        pos[bit]--;
                        if(pos[bit]==0)
                            currOr-=(1<<bit);
                    }
                }
                left++;
            }
            right++;
        }
        return ans;
        
    }
}