class Solution {
    public int fib(int n) {
       return fibUtil(n, new int[n+1]); 
    }

    public int fibUtil(int n, int[] f){
        if(n == 0 || n == 1){
            return n;
        }

        if(f[n] != 0){
            return f[n];
        }

        f[n]=fibUtil(n-1,f)+fibUtil(n-2,f);
        return f[n];
    }
}