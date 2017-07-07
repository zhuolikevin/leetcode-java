/*
 * [551] Student Attendance Record I
 *
 * https://leetcode.com/problems/student-attendance-record-i
 *
 * Easy (43.54%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"PPALLP"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public boolean checkRecord(String s) {
        int absentCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                absentCount++;
                if (absentCount > 1) { return false; }
            } else if (s.charAt(i) == 'L') {
                if (i < s.length() - 2 && s.charAt(i+1) == 'L' && s.charAt(i+2) == 'L') { return false; }
            }
        }
        return true;
    }
}
