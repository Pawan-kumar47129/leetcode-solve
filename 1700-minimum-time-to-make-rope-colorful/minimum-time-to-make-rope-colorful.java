class Solution {
    public int minCost(String colors, int[] neededTime) {
        int ans=0,n=colors.length();
        int prev=0,curr=1;
        while(curr<n){
            int sum=neededTime[prev];
            int max=neededTime[prev];
            while(curr<n && colors.charAt(curr)==colors.charAt(prev)){
                sum+=neededTime[curr];
                max=Math.max(max,neededTime[curr]);
                curr++;
            }
            if(curr-prev>1){
                ans+=sum-max;
            }
            prev=curr;
            curr++;
        }
        return ans;
    }
}