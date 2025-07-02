/*class Solution {
    int mod = (int) 1e9 + 7;
    public int possibleStringCount(String word, int k) {
        //group the all string if s=aaabbbcccaaa then like this aaa bbb ccc aaa
        List<Integer> group = new ArrayList<>();
        int n = word.length();
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                count++;
            } else {
                group.add(count);
                count = 1;
            }
        }
        group.add(count);
        long allArrange = 1;
        for (int i = 0; i < group.size(); i++) {
            allArrange = (allArrange * group.get(i)) % mod;
        }
        if (group.size() >= k)// all are valid
            return (int)allArrange;
        //find invalid substring means less than k size
        Long[][]dp=new Long[group.size()][k];
        long invalid = solve(0, 0, group, k,dp);

        int result=(int)(allArrange-invalid);
        if(result<0) return mod+result;
        return result;
    }

    private long solve(int index, int len, List<Integer> group, int k,Long[][]dp) {
        if (index >= group.size()) {
            if (len < k)
                return 1;
            return 0;
        }
        if(dp[index][len]!=null) return dp[index][len];
        long result = 0;
        for (int take = 1; take <= group.get(index); take++) {
            if (len + take >= k)
                break;
            result = (result + solve(index + 1, len + take, group, k,dp)) % mod;
        }
        return dp[index][len]=result%mod;
    }
}*/

/*class Solution {
    int mod = (int) 1e9 + 7;
    public int possibleStringCount(String word, int k) {
        //group the all string if s=aaabbbcccaaa then like this aaa bbb ccc aaa
        List<Integer> group = new ArrayList<>();
        int n = word.length();
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                count++;
            } else {
                group.add(count);
                count = 1;
            }
        }
        group.add(count);
        long allArrange = 1;
        for (int i = 0; i < group.size(); i++) {
            allArrange = (allArrange * group.get(i)) % mod;
        }
        if (group.size() >= k)// all are valid
            return (int)allArrange;
        //find invalid substring means less than k size
        long invalid = solve(group, k);

        int result=(int)(allArrange-invalid);
        if(result<0) return mod+result;
        return result;
    }

    private long solve(List<Integer> group, int k) {
        int n=group.size();
        long[][]dp=new long[n+1][k];
        for(int len=0;len<k;len++){
            dp[n][len]=1;
        }
        for(int index=n-1;index>=0;index--){
            for(int len=k-1;len>=0;len--){
                long result = 0;
                for (int take = 1; take <= group.get(index); take++) {
                    if (len + take >= k)
                        break;
                    result = (result + dp[index + 1][len + take]) % mod;
                }
                dp[index][len]=result;
            }
        }
        return dp[0][0];
    }
}*/

class Solution {
    int mod = (int) 1e9 + 7;
    public int possibleStringCount(String word, int k) {
        //group the all string if s=aaabbbcccaaa then like this aaa bbb ccc aaa
        List<Integer> group = new ArrayList<>();
        int n = word.length();
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                count++;
            } else {
                group.add(count);
                count = 1;
            }
        }
        group.add(count);
        long allArrange = 1;
        for (int i = 0; i < group.size(); i++) {
            allArrange = (allArrange * group.get(i)) % mod;
        }
        if (group.size() >= k)// all are valid
            return (int)allArrange;
        //find invalid substring means less than k size
        long invalid = solve(group, k);

        int result=(int)(allArrange-invalid);
        if(result<0) return mod+result;
        return result;
    }

    private long solve(List<Integer> group, int k) {
    int n = group.size();
    long[][] dp = new long[n + 1][k];
    long[] prefix = new long[k];

    for (int len = 0; len < k; len++) {
        dp[n][len] = 1;
        prefix[len] = 1;
        if (len > 0) prefix[len] = (prefix[len] + prefix[len - 1]) % mod;
    }

    for (int index = n - 1; index >= 0; index--) {
        for (int len = k - 1; len >= 0; len--) {
            int start = len + 1;
            int end = Math.min(len + group.get(index), k - 1);
            long result = 0;
            if (start <= end) {
                result = prefix[end];
                if (start > 0) result = (result - prefix[start - 1] + mod) % mod;
            }
            dp[index][len] = result;
        }

        for (int i = 0; i < k; i++) {
            prefix[i] = dp[index][i];
            if (i > 0) prefix[i] = (prefix[i] + prefix[i - 1]) % mod;
        }
    }

    return dp[0][0];
}
}