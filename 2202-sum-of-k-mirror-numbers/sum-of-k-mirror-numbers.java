class Solution {
    public long kMirror(int k, int n) {
        long sum = 0;
        int count = 0;
        int len = 1;

        while (count < n) {
            // generate odd-length palindromes
            for (long root = (long) Math.pow(10, len - 1); count < n && root < (long) Math.pow(10, len); root++) {
                String left = Long.toString(root);
                String right = new StringBuilder(left.substring(0, left.length() - 1)).reverse().toString();
                long candidate = Long.parseLong(left + right);

                if (isPalindromeInBase(candidate, k)) {
                    sum += candidate;
                    count++;
                }
            }

            // generate even-length palindromes
            for (long root = (long) Math.pow(10, len - 1); count < n && root < (long) Math.pow(10, len); root++) {
                String left = Long.toString(root);
                String right = new StringBuilder(left).reverse().toString();
                long candidate = Long.parseLong(left + right);

                if (isPalindromeInBase(candidate, k)) {
                    sum += candidate;
                    count++;
                }
            }

            len++;
        }

        return sum;
    }

    private boolean isPalindromeInBase(long num, int base) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append((char) ('0' + num % base));
            num /= base;
        }
        String s = sb.toString();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }
}
