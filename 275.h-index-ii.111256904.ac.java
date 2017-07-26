/*
 * [275] H-Index II
 *
 * https://leetcode.com/problems/h-index-ii
 *
 * Medium (34.26%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int left = 0;
        int right = citations.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] > citations.length - mid - 1) {
                right = mid;
            } else if (citations[mid] < citations.length - mid - 1) {
                left = mid;
            } else {
                return citations.length - mid - 1;
            }
        }
        
        if (citations[left] > citations.length - left - 1) {
            return citations.length - left;
        } else if (citations[right] > citations.length - right - 1) {
            return citations.length - right;
        } else {
            return 0;
        }
    }
}
