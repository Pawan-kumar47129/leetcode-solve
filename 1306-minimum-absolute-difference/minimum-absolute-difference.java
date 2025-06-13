class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int n=arr.length;
        int minDiff=Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            minDiff=Math.min(minDiff,Math.abs(arr[i]-arr[i-1]));
        }
        List<List<Integer>>ans=new ArrayList<>();
        for(int i=1;i<n;i++){
            if(Math.abs(arr[i]-arr[i-1])==minDiff){
                ans.add(Arrays.asList(arr[i-1],arr[i]));
            }
        }
        return ans;
    }
}