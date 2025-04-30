class Solution {
    public int maxPoints(int[][] points) {
        int max = 0;
        int n = points.length;
        for (int i = 0; i < n; i++) {
            HashMap<Double, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                    continue;
                }
                double slope = 0;
                if (points[i][0] == points[j][0]) {
                    slope = Double.POSITIVE_INFINITY;
                } else {
                    slope = (double)(points[i][1] - points[j][1]) / (points[i][0] - points[j][0]);
                }
                map.put(slope, map.getOrDefault(slope, 0)+1);
                max = Math.max(max, map.get(slope));
            }
        }
        return max + 1;
    }
}