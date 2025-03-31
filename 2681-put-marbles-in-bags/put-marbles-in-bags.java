/*
class Solution {
    private long solveForMax(int idx, int prev, int k, int[] weights) {
        if (idx >= weights.length)
            return (long) -1e12;
        if (k == 1)
            return weights[prev] + (long)weights[weights.length - 1];

        //make partition on idx index
        long cost = weights[prev] + (long)weights[idx] + solveForMax(idx + 1, idx + 1, k - 1, weights);
        //not make parition on idx index
        long notParition = solveForMax(idx + 1, prev, k, weights);
        return Math.max(cost, notParition);
    }

    private long solveForMin(int idx, int prev, int k, int[] weights) {
        if (idx >= weights.length)
            return (long) 1e12;
        if (k == 1)
            return weights[prev] + weights[weights.length - 1];

        //make partition on idx index
        long cost = weights[prev] + weights[idx] + solveForMin(idx + 1, idx + 1, k - 1, weights);
        //not make parition on idx index
        long notParition = solveForMin(idx + 1, prev, k, weights);
        return Math.min(cost, notParition);
    }

    public long putMarbles(int[] weights, int k) {
        long maxCost = solveForMax(0, 0, k, weights);
        long minCost = solveForMin(0, 0, k, weights);
        return maxCost - minCost;
    }
}*/

class Solution {
    public long putMarbles(int[] weights, int k) {
        int n=weights.length;
        int m=n-1;
        long[]pairSum=new long[m];
        for(int i=0;i<m;i++){
            pairSum[i]=weights[i]+weights[i+1];
        }
        Arrays.sort(pairSum);
        long minCost=0;
        long maxCost=0;
        for(int i=0;i<k-1;i++){
            minCost+=pairSum[i];
            maxCost+=pairSum[m-1-i];
        }
        return maxCost-minCost;
    }
}
