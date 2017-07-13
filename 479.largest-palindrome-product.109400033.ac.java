/*
 * [479] Largest Palindrome Product
 *
 * https://leetcode.com/problems/largest-palindrome-product
 *
 * Easy (18.76%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '1'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int largestPalindrome(int n) {
        if (n == 1) {
            return 9;
        }
        
        long upperBound = (long)(Math.pow(10, n) - 1);
        long lowerBound = upperBound / 10;
        
        long maxProduct = upperBound * upperBound;
        long firstHalf = maxProduct / (long)Math.pow(10, n);
        
        boolean findPalin = false;
        long thisPalin = (long)0;
        
        while (!findPalin) {
            thisPalin = formPalin(firstHalf);
            
            for (long i = upperBound; i > lowerBound; i--) {
                if (thisPalin / i > upperBound) {
                    break;
                }
                if (thisPalin / i <= lowerBound) {
                    continue;
                }
                if (thisPalin % i == 0) {
                    findPalin = true;
                    break;
                }
            }
            
            firstHalf -= 1;
        }
        
        return (int)(thisPalin % 1337);
    }
    
    private long formPalin(long firstHalf) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(firstHalf));
        String res = String.valueOf(firstHalf) + sb.reverse().toString();
        return Long.parseLong(res);
    }
}
