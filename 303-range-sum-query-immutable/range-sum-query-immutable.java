class NumArray {
    int[]segTree;
    int n;
    private void buildTree(int idx,int low,int high,int[]nums){
        if(low==high){
            segTree[idx]=nums[low];
            return;
        }
        int mid=low+(high-low)/2;
        buildTree(idx*2+1,low,mid,nums);
        buildTree(idx*2+2,mid+1,high,nums);
        segTree[idx]=segTree[idx*2+1]+segTree[idx*2+2];
    }
    public NumArray(int[] nums) {
        n=nums.length;
        segTree=new int[4*n];
        buildTree(0,0,n-1,nums);
    }
    
    private int getRangeSum(int idx,int low,int high,int left,int right){
        if(right<low || left>high) return 0;
        if(low>=left && right>=high) return segTree[idx];
        int mid=low+(high-low)/2;
        return getRangeSum(idx*2+1,low,mid,left,right)+getRangeSum(idx*2+2,mid+1,high,left,right);
    }
    public int sumRange(int left, int right) {
        return getRangeSum(0,0,n-1,left,right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */