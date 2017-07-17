/*
 * [89] Gray Code
 *
 * https://leetcode.com/problems/gray-code
 *
 * Medium (40.81%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '0'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        if (n == 0) {
            res.add(0);
            return res;
        }
        if (n == 1) {
            res.add(0);
            res.add(1);
            return res;
        }
        
        List<Integer> remains = grayCode(n - 1);
        res.addAll(remains);
        int prefix = 1 << (n - 1);
        for (int i = remains.size() - 1; i >= 0; i--) {
            res.add(remains.get(i) + prefix);
        }
        
        return res;
    }
}
