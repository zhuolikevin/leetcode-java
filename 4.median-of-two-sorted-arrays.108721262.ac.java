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
        if (nums1 == null && nums2 == null || nums1.length == 0 && nums2.length == 0) {
            return 0;
        }
        int len = nums1.length + nums2.length;
        if (len % 2 == 1) {
            return (double)findKth(nums1, nums2, 0, 0, len / 2 + 1);
        } else {
            return (findKth(nums1, nums2, 0, 0, len / 2) + findKth(nums1, nums2, 0, 0, len / 2 + 1)) / 2.0;
        }
    }
    
    private int findKth(int[] nums1, int[] nums2, int index1, int index2, int k) {
        if (index1 == nums1.length) {
            return nums2[index2 + k - 1];
        }
        if (index2 == nums2.length) {
            return nums1[index1 + k - 1];
        }
        if (k == 1) {
            return nums1[index1] < nums2[index2] ? nums1[index1] : nums2[index2];
        }
        
        int leftLen = k / 2;
        int rightLen = k - leftLen;
        
        if (index1 + leftLen > nums1.length) {
            return findKth(nums1, nums2, index1, index2 + rightLen, k - rightLen);
        } else if (index2 + rightLen > nums2.length) {
            return findKth(nums1, nums2, index1 + leftLen, index2, k - leftLen);
        } else {
            if (nums1[index1 + leftLen - 1] < nums2[index2 + rightLen - 1]) {
                return findKth(nums1, nums2, index1 + leftLen, index2, k - leftLen);
            } else {
                return findKth(nums1, nums2, index1, index2 + rightLen, k - rightLen);
            }
        }
    }
}
