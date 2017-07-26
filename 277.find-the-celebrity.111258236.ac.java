/*
 * [277] Find the Celebrity
 *
 * https://leetcode.com/problems/find-the-celebrity
 *
 * Medium (35.26%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '0 does not know 1; 1 does not know 0.'
 *
 * Can you solve this problem? 🤔
 */
/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int candidate = 0;
        for (int i = 1; i < n; i++) {
            if (knows(candidate, i)) {
                candidate = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (i == candidate) {
                continue;
            }
            if (!knows(i, candidate) || knows(candidate, i)) {
                return -1;
            }
        }
        return candidate;
    }
}
