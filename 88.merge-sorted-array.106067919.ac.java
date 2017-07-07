/*
 * [88] Merge Sorted Array
 *
 * https://leetcode.com/problems/merge-sorted-array
 *
 * Easy (31.78%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1]\n1\n[]\n0'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        int index1 = m - 1;
        int index2 = n - 1;
        while (index1 >= 0 && index2 >= 0) {
            if (nums1[index1] > nums2[index2]) {
                nums1[index] = nums1[index1];
                index1 -= 1;
            } else {
                nums1[index] = nums2[index2];
                index2 -= 1;
            }
            index -= 1;
        }
        while (index2 >= 0) {
            nums1[index2] = nums2[index2];
            index2 -= 1;
        }
    }
}
