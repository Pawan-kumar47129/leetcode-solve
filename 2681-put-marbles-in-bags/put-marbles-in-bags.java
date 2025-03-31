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
        // We collect and sort the value of all n - 1 pairs.
        int n = weights.length;
        int[] pairWeights = new int[n - 1];
        for (int i = 0; i < n - 1; ++i) {
            pairWeights[i] = weights[i] + weights[i + 1];
        }
        // We will sort only the first (n - 1) elements of the array.
        Arrays.sort(pairWeights, 0, n - 1);

        // Get the difference between the largest k - 1 values and the
        // smallest k - 1 values.
        long answer = 0l;
        for (int i = 0; i < k - 1; ++i) {
            answer += pairWeights[n - 2 - i] - pairWeights[i];
        }

        return answer;
    }
}
