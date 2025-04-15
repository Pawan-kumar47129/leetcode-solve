/*
class Solution {
    private boolean solve(int n, int turn, Boolean[][] dp) {
        // Base case: if only 1 is left
        if (n == 1 && turn == 1) return true;   // Bob's turn, no move => Alice wins
        if (n == 1 && turn == 0) return false;  // Alice's turn, no move => Bob wins

        // Check memoization table
        if (dp[n][turn] != null) return dp[n][turn];

        if (turn == 0) {
            // Alice's turn - she tries to force a win
            boolean win = solve(n - 1, 1, dp);
            if (win) return dp[n][turn] = true;

            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    // Try both n - i and n - (n / i)
                    win = solve(n - i, 1, dp) || solve(n - n / i, 1, dp);
                    if (win) return dp[n][turn] = true;
                }
            }

            return dp[n][turn] = false;

        } else {
            // Bob's turn - he tries to force a win (means Alice loses)
            boolean win = solve(n - 1, 0, dp);
            if (!win) return dp[n][turn] = false;

            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    // Bob wins if any move forces Alice into a losing position
                    win = solve(n - i, 0, dp) && solve(n - n / i, 0, dp);
                    if (!win) return dp[n][turn] = false;
                }
            }

            return dp[n][turn] = true;
        }
    }

    public boolean divisorGame(int n) {
        Boolean[][] dp = new Boolean[n + 1][2];  // dp[n][turn] => result of game for current n and turn
        return solve(n, 0, dp);  // 0 = Alice's turn, 1 = Bob's turn
    }
}*/

class Solution {
    public boolean divisorGame(int num) {
        boolean[][] dp = new boolean[num + 1][2];  // dp[n][turn] => result of game for current n and turn
        dp[1][0]=false;
        dp[1][1]=true;
        for(int n=2;n<=num;n++){
            for(int turn=0;turn<2;turn++){
                if (turn == 0) {
                    // Alice's turn - she tries to force a win
                    boolean win = dp[n - 1][1];
                    if(win){
                        dp[n][turn]=win;
                        continue;
                    }
                    for (int i = 2; i * i <= n; i++) {
                        if (n % i == 0) {
                            // Try both n - i and n - (n / i)
                            win = win || dp[n - i][1] || dp[n - n / i][1];
                            if (win)break;
                        }
                    }
                    dp[n][turn] = win;

                } else {
                    // Bob's turn - he tries to force a win (means Alice loses)
                    boolean win = dp[n - 1][0];
                    if (!win) {
                        dp[n][turn] = false;
                        continue;
                    }

                    for (int i = 2; i * i <= n; i++) {
                        if (n % i == 0) {
                            // Bob wins if any move forces Alice into a losing position
                            win = dp[n - i][0] && dp[n - n / i][0];
                            if (!win) break;
                        }
                    }

                    dp[n][turn] = win;
                }
            }
        }
        return dp[num][0]; 
    }
}

