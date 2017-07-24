/*
 * [311] Sparse Matrix Multiplication
 *
 * https://leetcode.com/problems/sparse-matrix-multiplication
 *
 * Medium (50.64%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[[1,0,0],[-1,0,3]]\n[[7,0,0],[0,0,0],[0,0,1]]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        if (A.length == 0 || A[0].length == 0 || B.length == 0 || B[0].length == 0 || A[0].length != B.length) {
            return new int[0][0];
        }
        
        int n = A.length;
        int k = A[0].length;
        int m = B[0].length;
        List<Map<Integer, Integer>> As = new ArrayList<>();
        List<Map<Integer, Integer>> Bs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < k; j++) {
                if (A[i][j] != 0) {
                    map.put(j, A[i][j]);
                }
            }
            As.add(map);
        }
        for (int j = 0; j < m; j++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < k; i++) {
                if (B[i][j] != 0) {
                    map.put(i, B[i][j]);
                }
            }
            Bs.add(map);
        }
        
        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = dotProduct(As.get(i), Bs.get(j));
            }
        }
        
        return res;
    }
    
    private int dotProduct(Map<Integer, Integer> v1, Map<Integer, Integer> v2) {
        if (v1.size() > v2.size()) {
            return dotProduct(v2, v1);
        }
        
        int sum = 0;
        for (int index : v1.keySet()) {
            if (v2.containsKey(index)) {
                sum += v1.get(index) * v2.get(index);
            }
        }
        
        return sum;
    }
}
