class Solution {
    public int longestMountain(int[] arr) {
        int curr=0,n=arr.length;
        int ans=0;
        while(curr<n){
            if(curr+1<n && arr[curr]>=arr[curr+1]){
                curr++;
                continue;
            }
            //find increasing subarray
            int incrStart=curr;
            while(curr+1<n && arr[curr]<arr[curr+1])curr++;
            //decreasing subarray
            int decrStart=curr;
            while(curr+1<n && arr[curr]>arr[curr+1])curr++;
            if(curr-decrStart!=0){
                ans=Math.max(ans,curr-incrStart+1);
            }
            if(curr==n-1) break;
        }
        return ans;
    }
}