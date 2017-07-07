/*
 * [481] Magical String
 *
 * https://leetcode.com/problems/magical-string
 *
 * Medium (45.13%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '1'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int magicalString(int n) {
        if (n <= 0) { return 0; }
        if (n <= 3) { return 1; }
        int[] str = new int[n + 1];
        str[0] = 1; str[1] = 2; str[2] = 2;
        int curIndex = 3;
        int res = 1;
        int curCountIndex = 2;
        int num = 1;
        while (curIndex < n) {
            int curCount = str[curCountIndex];
            for (int i = 0; i < curCount; i++) {
                str[curIndex] = num;
                curIndex++;
                if (num == 1) { res++; }
            }
            curCountIndex++;
            num = num ^ 3;
        }
        if (curIndex == n + 1 && str[n] == 1) {
            res -= 1;
        }
        return res;
    }
}
