class Solution {
    int countDigit(int nums){
        if(nums<10) return 1;
        if(nums>=10 && nums<=99) return 2;
        if(nums>=100 && nums<=999) return 3;
        if(nums>=1000 && nums<=9999) return 4;
        if(nums>=10000 && nums<=99999) return 5;
        return 0;
    }
    private boolean isSymmetric(int nums,int totalDigit){
        int count=totalDigit/2;
        int sum=0;
        int halfSum=0;
        while(nums>0){
            int rem=nums%10;
            sum+=rem;
            if(totalDigit<=count) halfSum+=rem;
            totalDigit--;
            nums/=10;
        }
        if((2*halfSum)==sum)return true;
        return false;

    }
    public int countSymmetricIntegers(int low, int high) {
        int ans=0;
        while(low<=high){
            int n=countDigit(low);
            //System.out.println(n +" " + low);
            if(n%2==1){
                low=(int)Math.pow(10,n);
                continue;
            }
            if(isSymmetric(low,n)) ans++;
            low++;
        }
        return ans;
    }
}