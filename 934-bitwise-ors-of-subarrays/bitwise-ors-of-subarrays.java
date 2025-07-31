class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        HashSet<Integer>prev=new HashSet<>();
        HashSet<Integer>ans=new HashSet<>();
        int n=arr.length;
        for(int i=0;i<n;i++){
            HashSet<Integer>curr=new HashSet<>();
            for(int ele:prev){
                curr.add(arr[i]|ele);
                ans.add(arr[i]|ele);
            }
            curr.add(arr[i]);
            ans.add(arr[i]);
            prev=curr;
        }
        return ans.size();
    }
}