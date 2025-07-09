class Solution {
    public String getPermutation(int n, int k) {
        int fact=1;
        List<Integer>nums=new ArrayList<>();
        for(int i=1;i<n;i++){
            fact=fact*i;//factorial found (n-1) because using first any element then rest have choice
            nums.add(i);
        }
        //add last n value
        nums.add(n);
        StringBuilder result=new StringBuilder();
        k=k-1;//follow zero based indexing
        while(true){
            int firstElement=nums.get(k/fact);
            result.append(firstElement);
            nums.remove(k/fact);//remove that element becuase we put in ans
            k=k%fact;
            if(nums.size()==0) break;
            fact=fact/nums.size();
        }
        return result.toString();
    }
}