/*
 * [38] Count and Say
 *
 * https://leetcode.com/problems/count-and-say
 *
 * Easy (34.18%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '1'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public String countAndSay(int n) {
        String last = "1";
        for (int i = 2; i <= n; i++) {
            String cur = "";
            int count = 1;
            char candidate = last.charAt(0);
            for (int j = 1; j < last.length(); j++) {
                if (last.charAt(j) == candidate) { count++; }
                else {
                    cur = cur + String.valueOf(count) + String.valueOf(candidate);
                    count = 1;
                    candidate = last.charAt(j);
                }
            }
            cur = cur + String.valueOf(count) + String.valueOf(candidate);
            last = cur;
        }
        return last;
    }
}
