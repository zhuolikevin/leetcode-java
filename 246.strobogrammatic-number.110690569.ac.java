/*
 * [246] Strobogrammatic Number
 *
 * https://leetcode.com/problems/strobogrammatic-number
 *
 * Easy (39.64%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"1"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public boolean isStrobogrammatic(String num) {
        if (num.equals("0")) {
            return true;
        }
        
        int len = num.length();
        Set<Character> set = new HashSet<>();
        set.add('0');
        set.add('1');
        set.add('8');
        
        if (num.charAt(len - 1) == '0') {
            return false;
        }
        if (len % 2 == 1 && !set.contains(num.charAt(len / 2))) {
            return false;
        }
        
        int left = 0;
        int right = len - 1;
        while (left < right) {
            char n1 = num.charAt(left);
            char n2 = num.charAt(right);
            if (n1 != n2) {
                if (!(n1 == '6' && n2 == '9' || n1 == '9' && n2 == '6')) {
                    return false;
                }
            } else {
                if (!set.contains(n1)) {
                    return false;
                }
            }
            left++;
            right--;
        }
        
        return true;
    }
}
