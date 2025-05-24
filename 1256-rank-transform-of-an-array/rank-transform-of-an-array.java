class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int copy[]=arr.clone();
        Arrays.sort(copy);
        int rank=1,n=arr.length;
        HashMap<Integer,Integer>rankMap=new HashMap<>();
        for(int i=0;i<n;i++){
            if(rankMap.containsKey(copy[i])) continue;
            rankMap.put(copy[i],rank);
            rank++;
        }
        for(int i=0;i<n;i++){
            copy[i]=rankMap.get(arr[i]);
        }
        return copy;
    }
}