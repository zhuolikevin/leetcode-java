/*
 * [293] Flip Game
 *
 * https://leetcode.com/problems/flip-game
 *
 * Easy (55.54%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"++++"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                res.add(s.substring(0, i) + "--" + s.substring(i + 2));
            }
        }
        
        return res;
    }
}
