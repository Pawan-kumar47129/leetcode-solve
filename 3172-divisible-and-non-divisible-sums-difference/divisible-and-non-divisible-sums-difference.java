class Solution {
    public int differenceOfSums(int n, int m) {
        int div=n/m;
        long totalSum=n*(n+1)/2L;
        long divisibleSum=div*(2*m + (div-1)*m)/2;
        long notDivisibleSum=totalSum-divisibleSum;
        return (int)(notDivisibleSum-divisibleSum);
    }
}