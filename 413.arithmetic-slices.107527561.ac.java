/*
 * [413] Arithmetic Slices
 *
 * https://leetcode.com/problems/arithmetic-slices
 *
 * Medium (54.64%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,2,3,4]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3) { return 0; }
        int res = 0;
        int diff = A[1] - A[0];
        int len = 2;
        int i = 2;
        while (i < A.length) {
            if (A[i] - A[i-1] == diff) {
                len++;
                i++;
            } else {
                res += (len - 1) * (len - 2) / 2;
                len = 2;
                i += 1;
                if (i < A.length) {
                    diff = A[i-1] - A[i-2];
                }
            }
        }
        res += (len - 1) * (len - 2) / 2;
        
        return res;
    }
}
