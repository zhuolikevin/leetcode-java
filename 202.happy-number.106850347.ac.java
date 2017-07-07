/*
 * [202] Happy Number
 *
 * https://leetcode.com/problems/happy-number
 *
 * Easy (40.40%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '1'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            int newN = 0;
            while (n > 0) {
                int remain = n % 10;
                newN += remain * remain;
                n = n / 10;
            }
            if (set.contains(newN)) { return false; }
            set.add(newN);
            n = newN;
        }
        return true;
    }
}
