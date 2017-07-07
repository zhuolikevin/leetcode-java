/*
 * [278] First Bad Version
 *
 * https://leetcode.com/problems/first-bad-version
 *
 * Easy (25.06%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '1 version\n1 is the first bad version.'
 *
 * Can you solve this problem? 🤔
 */
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if (n <= 0) {
            return 0;
        }
        
        int start = 1;
        int end = n;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if (isBadVersion(start)) {
            return start;
        }
        
        if (isBadVersion(end)) {
            return end;
        }
        
        return -1;
    }
}
