/*
 * [4] Median of Two Sorted Arrays
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays
 *
 * Hard (21.48%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,3]\n[2]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len == 0) {
            return 0.0;
        }
        
        if (len % 2 == 1) {
            return (double)findKth(nums1, 0, nums2, 0, len / 2 + 1);
        } else {
            return ((double)findKth(nums1, 0, nums2, 0, len / 2) + (double)findKth(nums1, 0, nums2, 0, len / 2 + 1)) / 2;
        }
    }
    
    private int findKth(int[] nums1, int i, int[] nums2, int j, int k) {
        if (i == nums1.length) {
            return nums2[j + k - 1];
        }
        if (j == nums2.length) {
            return nums1[i + k - 1];
        }
        
        if (k == 1) {
            return nums1[i] < nums2[j] ? nums1[i] : nums2[j];
        }
        
        int len1 = k / 2;
        int len2 = k - len1;
        
        if (i + len1 > nums1.length) {
            return findKth(nums1, i, nums2, j + len2, k - len2);
        } else if (j + len2 > nums2.length) {
            return findKth(nums1, i + len1, nums2, j, k - len1);
        } else {
            if (nums1[i + len1 - 1] < nums2[j + len2 - 1]) {
                return findKth(nums1, i + len1, nums2, j, k - len1);
            } else {
                return findKth(nums1, i, nums2, j + len2, k - len2);
            }
        }
    }
}
