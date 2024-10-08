import java.math.BigInteger;
//for large input as 19,38 we use BigInteger..........
class Solution {
    public int numTrees(int n) {
        BigInteger n1 = factorial(BigInteger.valueOf(2 * n));
        BigInteger n2 = factorial(BigInteger.valueOf(n + 1));
        BigInteger n3 = factorial(BigInteger.valueOf(n));
        
        BigInteger result = n1.divide(n2.multiply(n3));
        
        return result.intValue();
    }
    
    private BigInteger factorial(BigInteger n) {
        if (n.equals(BigInteger.ZERO) || n.equals(BigInteger.ONE)) {
            return BigInteger.ONE;
        }
        return n.multiply(factorial(n.subtract(BigInteger.ONE)));
    }
}