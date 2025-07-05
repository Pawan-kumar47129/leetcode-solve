class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        int ans=-1;
        for(Map.Entry<Integer,Integer>el:map.entrySet()){
            if(el.getKey()==el.getValue())
                ans=Math.max(ans,el.getKey());
        }
        return ans;
    }
}