class NumArray {
    int[]segTree;
    int n;
    public NumArray(int[] nums) {
        n=nums.length;
        segTree=new int[4*n];
        buildTree(0,0,n-1,nums);
    }
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
    private void updateTree(int idx,int index,int val,int low,int high){
        if(low==high){
            segTree[idx]=val;
            return;
        }
        int mid=low+(high-low)/2;
        if(index<=mid){
            updateTree(idx*2+1,index,val,low,mid);
        }else{
            updateTree(idx*2+2,index,val,mid+1,high);
        }
        segTree[idx]=segTree[idx*2+1]+segTree[idx*2+2];
    }
    public void update(int index, int val) {
        updateTree(0,index,val,0,n-1);
    }
    
    private int getRangeSum(int idx,int low,int high,int left,int right){
        if(right<low || left>high) return 0;
        if(left<=low && high<=right) return segTree[idx];
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
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */