/*
 * [414] Third Maximum Number
 *
 * https://leetcode.com/problems/third-maximum-number
 *
 * Easy (27.76%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[3,2,1]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int thirdMax(int[] nums) {
        int first = Integer.MIN_VALUE;
        int second = first;
        int third = second;
        
        Integer n1 = null;
        Integer n2 = null;
        boolean find = false;
        for (int num : nums) {
            if (n1 == null) { n1 = num; }
            if (n1 != null && n2 == null && num != n1) { n2 = num; }
            if (n1 != null && n2 != null && num != n1 && num != n2) { find = true; }
            if (num > first) {
                third = second;
                second = first;
                first = num;
            } else if (num > second && num < first) {
                third = second;
                second = num;
            } else if (num > third && num < second) {
                third = num;
            }
        }
        
        return find ? third : first;
    }
}
