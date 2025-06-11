/*class Solution {
    public int maxDifference(String s, int k) {
        int n = s.length();
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i <= n - k; i++) {
            int[] freq = new int[5];
            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - '0']++;

                if (j - i + 1 >= k) { // only check substrings of length >= k
                    int maxOdd = Integer.MIN_VALUE;
                    int minEven = Integer.MAX_VALUE;

                    for (int d = 0; d < 5; d++) {
                        if (freq[d] > 0) {
                            if (freq[d] % 2 == 1)
                                maxOdd = Math.max(maxOdd, freq[d]);
                            else
                                minEven = Math.min(minEven, freq[d]);
                        }
                    }

                    if (maxOdd != Integer.MIN_VALUE && minEven != Integer.MAX_VALUE) {
                        ans = Math.max(ans, maxOdd - minEven);
                    }
                }
            }
        }

        return (ans == Integer.MIN_VALUE) ? -1 : ans;
    }
}
*/
class Solution {

    public int maxDifference(String s, int k) {
        int n = s.length();
        int ans = Integer.MIN_VALUE;
        for (char a = '0'; a <= '4'; ++a) {
            for (char b = '0'; b <= '4'; ++b) {
                if (a == b) {
                    continue;
                }
                int[] best = new int[4];
                Arrays.fill(best, Integer.MAX_VALUE);
                int cnt_a = 0, cnt_b = 0;
                int prev_a = 0, prev_b = 0;
                int left = -1;

                for (int right = 0; right < n; ++right) {
                    cnt_a += (s.charAt(right) == a) ? 1 : 0;
                    cnt_b += (s.charAt(right) == b) ? 1 : 0;

                    while (right - left >= k && cnt_b - prev_b >= 2) {
                        int left_status = getStatus(prev_a, prev_b);
                        best[left_status] = Math.min(
                            best[left_status],
                            prev_a - prev_b
                        );
                        ++left;
                        prev_a += (s.charAt(left) == a) ? 1 : 0;
                        prev_b += (s.charAt(left) == b) ? 1 : 0;
                    }

                    int right_status = getStatus(cnt_a, cnt_b);
                    if (best[right_status ^ 0b10] != Integer.MAX_VALUE) {
                        ans = Math.max(
                            ans,
                            cnt_a - cnt_b - best[right_status ^ 0b10]
                        );
                    }
                }
            }
        }
        return ans;
    }

    private int getStatus(int cnt_a, int cnt_b) {
        return ((cnt_a & 1) << 1) | (cnt_b & 1);
    }
}
