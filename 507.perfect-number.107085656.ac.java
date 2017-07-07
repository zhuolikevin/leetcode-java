/*
 * [507] Perfect Number
 *
 * https://leetcode.com/problems/perfect-number
 *
 * Easy (33.66%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '28'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num == 1) { return false; }
        int sum = 1;
        int i = 2;
        while (i < num) {
            if (num / i < i) { break; }
            if (num == i * i) {
                sum += i;
                break;
            }
            if (num % i == 0) {
                sum += i;
                sum += num / i;
            }
            i++;
        }
        return sum == num;
    }
}
