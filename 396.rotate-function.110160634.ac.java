/*
 * [396] Rotate Function
 *
 * https://leetcode.com/problems/rotate-function
 *
 * Medium (32.30%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int maxRotateFunction(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int sum = 0;
        int[] F = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            F[0] += i * A[i];
        }
        int max = F[0];
        for (int i = 1; i < F.length; i++) {
            int B0 = A.length - i;
            F[i] = F[i - 1] + sum - A.length * A[B0];
            max = Math.max(max, F[i]);
        }
        return max;
    }
}
