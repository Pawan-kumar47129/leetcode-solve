class Solution {
    int[] segTree; // Segment tree to store indices of max height in ranges

    // Build the segment tree: each node stores index of the max height in the range [low, high]
    private void buildSegTree(int idx, int low, int high, int[] heights) {
        if (low == high) {
            segTree[idx] = low; // Leaf node stores its own index
            return;
        }
        int mid = low + (high - low) / 2;
        // Recursively build left and right children
        buildSegTree(2 * idx + 1, low, mid, heights);
        buildSegTree(2 * idx + 2, mid + 1, high, heights);

        // Store index of the taller building between the two children
        int leftMaxIdx = segTree[2 * idx + 1];
        int rightMaxIdx = segTree[2 * idx + 2];
        if (heights[leftMaxIdx] < heights[rightMaxIdx]) {
            segTree[idx] = rightMaxIdx;
        } else {
            segTree[idx] = leftMaxIdx;
        }
    }

    // Query the segment tree for the index of the tallest building in range [left, right]
    private int queryMaxIndex(int idx, int low, int high, int left, int right, int[] heights) {
        // If current segment is completely outside the query range
        if (high < left || low > right) return -1;

        // If current segment is completely inside the query range
        if (left <= low && high <= right) {
            return segTree[idx];
        }

        // Partial overlap: query both children
        int mid = low + (high - low) / 2;
        int leftIdx = queryMaxIndex(2 * idx + 1, low, mid, left, right, heights);
        int rightIdx = queryMaxIndex(2 * idx + 2, mid + 1, high, left, right, heights);

        // Return the index of the taller building among valid results
        if (leftIdx != -1 && rightIdx != -1) {
            return (heights[leftIdx] > heights[rightIdx]) ? leftIdx : rightIdx;
        } else {
            return (leftIdx == -1) ? rightIdx : leftIdx;
        }
    }

    
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;
        segTree = new int[4 * n]; // Segment tree size
        Arrays.fill(segTree, -1); // Initialize with invalid indices

        // Build the segment tree for the heights array
        buildSegTree(0, 0, n - 1, heights);

        int q = queries.length;
        int[] ans = new int[q];

        for (int i = 0; i < q; i++) {
            int a = queries[i][0];
            int b = queries[i][1];

            if (a == b) {
                ans[i] = a;
            } else {
                int max = Math.max(a, b);  // Start search from max(a, b)
                int smaller=Math.min(a,b);
                int left=max;
                int right = n - 1;          // End of the buildings
                ans[i] = -1;                // Default to -1 (no building found)

                // Binary search to find leftmost valid building
                while (left <= right) {
                    int mid = left + (right - left) / 2;

                    // Query the index of the tallest building in range [left, mid]
                    int curr = queryMaxIndex(0, 0, n - 1, left, mid, heights);

                    // Check if this building is taller or equal to both a and b
                    if (curr != -1 && curr>smaller && heights[curr] > heights[smaller] && heights[curr] >= heights[max]) {
                        ans[i] = curr;     // Store current index as a valid answer
                        right = mid - 1;   // Try to find an even smaller (leftmost) index
                    } else {
                        left = mid + 1;    // Move to the right side
                    }
                }
            }
        }
        return ans; // Return all answers
    }
}
