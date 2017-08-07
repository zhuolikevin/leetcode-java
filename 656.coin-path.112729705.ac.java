/*
 * [656] Coin Path
 *
 * https://leetcode.com/problems/coin-path
 *
 * Hard (19.79%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,2,4,-1,2]\n2'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public List<Integer> cheapestJump(int[] A, int B) {
        List<Integer> res = new ArrayList<>();
        if (A == null || A.length == 0 || A[A.length - 1] == -1) {
            return res;
        }
        
        int[] cost = new int[A.length];
        int[] forward = new int[A.length];
        Arrays.fill(cost, Integer.MAX_VALUE);
        Arrays.fill(forward, -1);
        cost[A.length - 1] = A[A.length - 1];
        
        for (int i = A.length - 2; i >= 0; i--) {
            if (A[i] == -1) {
                continue;
            }
            for (int j = 1; j <= B; j++) {
                if (i + j >= A.length || A[i + j] == -1) {
                    continue;
                }
                
                if (cost[i + j] + A[i] < cost[i] && cost[i + j] < Integer.MAX_VALUE) {
                    cost[i] = cost[i + j] + A[i];
                    forward[i] = i + j;
                }
            }
        }
        
        if (cost[0] == Integer.MAX_VALUE) {
            return res;
        }
        
        int k = 0;
        while (k != -1) {
            res.add(k + 1);
            k = forward[k];
        }
        
        return res;
    }
}
