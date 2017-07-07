/*
 * [390] Elimination Game
 *
 * https://leetcode.com/problems/elimination-game
 *
 * Medium (41.29%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '9'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int lastRemaining(int n) {
        int step = 1;
        int head = 1;
        int remain = n;
        boolean left = true;
        while (remain > 1) {
            if (left || remain % 2 == 1) {
                head += step;
            }
            remain /= 2;
            step *= 2;
            left = !left;
        }
        return head;
    }
}
