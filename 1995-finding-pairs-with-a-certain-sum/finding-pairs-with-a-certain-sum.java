class FindSumPairs {
    HashMap<Integer,Integer> num1Map,num2Map;
    int []num2;
    public FindSumPairs(int[] num1, int[] num2) {
        num1Map=new HashMap<>(num1.length);
        num2Map=new HashMap<>(num2.length);
        this.num2=new int[num2.length];
        this.num2=num2;
        int num2Index=0;
        for(int i=0;i<num1.length;i++){
            num1Map.put(num1[i],num1Map.getOrDefault(num1[i],0)+1);
            if(num2Index<num2.length){
                num2Map.put(num2[num2Index],num2Map.getOrDefault(num2[num2Index],0)+1);
                num2Index++;
            }
        }
        while(num2Index<num2.length){
            num2Map.put(num2[num2Index],num2Map.getOrDefault(num2[num2Index],0)+1);
            num2Index++;
        }
    }
    
    public void add(int index, int val) {
        int prevValue=num2[index];
        int freq=num2Map.get(prevValue);
        if(freq==1)num2Map.remove(prevValue);
        else num2Map.put(prevValue,freq-1);
        num2[index]+=val;
        num2Map.put(num2[index],num2Map.getOrDefault(num2[index],0)+1);
    }
    
    public int count(int tot) {
        int ans=0;
        for(var ele:num1Map.entrySet()){
            int value=ele.getKey();
            int freq=ele.getValue();
            int search=tot-value;
            int f=num2Map.getOrDefault(search,0);
            ans+=freq*f;
        }
        return ans;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */