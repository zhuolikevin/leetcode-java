/*
 * [386] Lexicographical Numbers
 *
 * https://leetcode.com/problems/lexicographical-numbers
 *
 * Medium (40.92%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '13'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        int cur = 1;
        for (int i = 1; i <= n; i++) {
            res.add(cur);
            if (cur * 10 <= n) {
                cur = cur * 10;
            } else if (cur % 10 != 9 && cur + 1 <= n) {
                cur++;
            } else {
                while ((cur / 10) % 10 == 9) {
                    cur = cur / 10;
                }
                cur = cur / 10 + 1;
            }
        }
        return res;
    }
}
