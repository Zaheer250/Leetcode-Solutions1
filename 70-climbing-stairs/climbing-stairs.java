class Solution {
    public int climbStairs(int n) {
        return ways(n,new int[n+1]);
    }

    public int ways(int n, int[] dp){
        if(n == 0){
            return 1;
        }
        if(n < 0){
            return 0;
        }
        if(dp[n] != 0){
            return dp[n];
        }
        dp[n]=ways(n-1,dp)+ways(n-2,dp);
        return dp[n];
    }
}