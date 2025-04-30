class Solution {
    public String addBinary(String a, String b) {
        int n = a.length() - 1;
        int m = b.length() - 1;
        int carry = 0;
        StringBuilder ans = new StringBuilder();
        while (n >= 0 && m >= 0) {
            char ch1 = a.charAt(n);
            char ch2 = b.charAt(m);
            int val = (int) ((ch1 - '0') + (ch2 - '0'));
            //int val=(int)(ch)-'0';
            val += carry;
            if (val == 0) {
                ans.append('0');
                carry = 0;
            } else if (val == 1) {
                ans.append('1');
                carry = 0;
            } else if (val == 2) {
                ans.append('0');
                carry = 1;
            } else {
                ans.append('1');
                carry = 1;
            }
            n--;
            m--;
        }
        while (n >= 0) {
            char ch = a.charAt(n);
            int val = (int) (ch - '0');
            val += carry;
            if (val == 0) {
                ans.append('0');
                carry = 0;
            } else if (val == 1) {
                ans.append('1');
                carry = 0;
            } else {
                ans.append('0');
                carry = 1;
            }
            n--;
        }
        while (m >= 0) {
            char ch = b.charAt(m);
            int val = (int) (ch - '0');
            val += carry;
            if (val == 0) {
                ans.append('0');
                carry = 0;
            } else if (val == 1) {
                ans.append('1');
                carry = 0;
            } else {
                ans.append('0');
                carry = 1;
            }
            m--;
        }
        if (carry == 1) {
            ans.append('1');
        }
        return ans.reverse().toString();
    }
}