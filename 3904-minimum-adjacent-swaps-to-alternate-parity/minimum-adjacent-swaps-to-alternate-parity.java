class Solution {
    private void swap(int i,int j,int[]nums){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public int minSwaps(int[] nums) {
        int []num1=nums.clone();
        // we want to start with even number
        int i=0;
        int j=1;
        int n=nums.length;
        int ans1=0;
        while(i<n && j<n){
            if((i%2==0 && num1[i]%2==0)|| (i%2==1 && num1[i]%2==1)){
                i++;
                if(j<i)j++;
            }else{
                int even=i%2==0?0:1;
                while(j<n && num1[j]%2!=even){
                    j++;
                }
                if(j!=n){
                    swap(i,j,num1);
                    ans1+=j-i;
                }else{
                    ans1=-1;
                    break;
                }
                i++;
            }
        }
        //we want to start with odd
        i=0;j=1;
        int[]num2=nums.clone();
        int ans2=0;
        while(i<n && j<n){
            if((i%2==0 && num2[i]%2==1)|| (i%2==1 && num2[i]%2==0)){
                i++;
                if(j<i)j++;
            }else{
                int odd=i%2==0?1:0;
                while(j<n && num2[j]%2!=odd){
                    j++;
                }
                if(j!=n){
                    swap(i,j,num2);
                    ans2+=j-i;
                }else{
                    ans2=-1;
                    break;
                }
                i++;
            }
        }
        if(ans1==-1 && ans2==-1) return -1;
        if(ans1==-1) return ans2;
        if(ans2==-1) return ans1;
        return Math.min(ans1,ans2);
    }
}