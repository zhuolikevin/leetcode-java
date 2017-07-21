/*
 * [60] Permutation Sequence
 *
 * https://leetcode.com/problems/permutation-sequence
 *
 * Medium (28.28%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '1\n1'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public String getPermutation(int n, int k) {
        if (n <= 0 || k <= 0) {
            return "";
        }
        
        int[] candidates = new int[n];
        for (int i = 0; i < n; i++) {
            candidates[i] = i + 1;
        }
        Set<Integer> visited = new HashSet<>();
        return helper(n, k - 1, candidates, visited);
    }
    
    private String helper(int n, int k, int[] candidates, Set<Integer> visited) {
        if (n == 1) {
            for (int candidate : candidates) {
                if (!visited.contains(candidate)) {
                    return String.valueOf(candidate);
                }
            }
        }
        
        int fact = fact(n - 1);
        int firstNumCount = k / fact + 1;
        int newK = k % fact;
        for (int candidate : candidates) {
            if (!visited.contains(candidate)) {
                firstNumCount--;
                if (firstNumCount == 0) {
                    visited.add(candidate);
                    return String.valueOf(candidate) + helper(n - 1, newK, candidates, visited);
                }
            }
        }
        
        return "";
    }
    
    private int fact(int n) {
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        return res;
    }
}
