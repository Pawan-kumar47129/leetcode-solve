class Solution {
    public int[] sumZero(int n) {
        int []arr=new int[n];
        int num=1; 
        int i=0;
        while(num<=n/2){
            arr[i++]=num;
            arr[i++]=num*-1;
            num++;
        }
        if(n%2==1)arr[i]=0;
        return arr;
    }
}