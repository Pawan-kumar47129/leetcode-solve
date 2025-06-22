class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n=s.length();
        int size=(n/k)+(n%k==0?0:1);
        String arr[]=new String[size];
        int i=0;
        int index=0;
        while(i<n){
            int nextIndex=i+k;
            if(nextIndex<=n){
                arr[index++]=s.substring(i,nextIndex);
            }else{
                arr[index++]=s.substring(i,n);
            }
            i=i+k;
        }
        index--;
        StringBuilder last=new StringBuilder();
        if(arr[index].length()<k){
            for(int j=1;j<=k-arr[index].length();j++){
                last.append(fill);
            }
            arr[size-1]=arr[size-1]+last.toString();
        }
        return arr;

    }
}