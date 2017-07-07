/*
 * [454] 4Sum II
 *
 * https://leetcode.com/problems/4sum-ii
 *
 * Medium (46.29%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,2]\n[-2,-1]\n[-1,2]\n[0,2]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int res = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = C[i] + D[j];
                if (map.containsKey(0 - sum)) {
                    res += map.get(0 - sum);
                }
            }
        }
        return res;
    }
}
