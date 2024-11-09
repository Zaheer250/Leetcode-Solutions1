class Solution {
    public int tribonacci(int n) {
        return helper(n, new int[n+1]);
    }

    public int helper(int n, int[] dp){
        if(n == 0 || n == 1){
            return n;
        }
        if(n < 0){
            return 0;
        }

        if(dp[n] != 0){
            return dp[n];
        }
        dp[n]=helper(n-1,dp)+helper(n-2,dp)+helper(n-3,dp);
        return dp[n];
    }
}