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
        if (len % 2 == 0) {
            return (double)(findKth(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, len / 2) + findKth(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, len / 2 + 1)) / 2.0;
        } else {
            return (double)findKth(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, len / 2 + 1);
        }
    }
    
    private int findKth(int[] nums1, int left1, int right1, int[] nums2, int left2, int right2, int k) {
        if (left2 > right2) {
            return nums1[left1 + k - 1];
        }
        if (left1 > right1) {
            return nums2[left2 + k - 1];
        }
        
        if (k == 1) {
            return Math.min(nums1[left1], nums2[left2]);
        }
        
        int leftLen = k / 2;
        int rightLen = k - leftLen;
        
        if (leftLen > right1 - left1 + 1) {
            return findKth(nums1, left1, right1, nums2, left2 + rightLen, right2, k - rightLen);
        } else if (rightLen > right2 - left2 + 1) {
            return findKth(nums1, left1 + leftLen, right1, nums2, left2, right2, k - leftLen);
        } else {
            if (nums1[left1 + leftLen - 1] > nums2[left2 + rightLen - 1]) {
                return findKth(nums1, left1, right1, nums2, left2 + rightLen, right2, k - rightLen);
            } else {
                return findKth(nums1, left1 + leftLen, right1, nums2, left2, right2, k - leftLen);
            }
        }
    }
}
