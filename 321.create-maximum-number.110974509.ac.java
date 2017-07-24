/*
 * [321] Create Maximum Number
 *
 * https://leetcode.com/problems/create-maximum-number
 *
 * Hard (24.47%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[3,4,6,5]\n[9,1,2,5,8,3]\n5'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        if (nums1 == null || nums2 == null || k <= 0) {
            return new int[0];
        }
        
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] res = new int[k];
        for (int i = 0; i <= Math.min(k, len1); i++) {
            if (k - i > len2) {
                continue;
            }
            int[] max1 = findMax(nums1, i);
            int[] max2 = findMax(nums2, k - i);
            int[] candidate = merge(max1, max2, k);
            if (compare(candidate, 0, res, 0)) {
                res = candidate;
            }
        }
        
        return res;
    }
    
    private int[] findMax(int[] nums, int k) {
        int[] res = new int[k];
        if (k == 0) {
            return res;
        }
        
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            while (len > 0 && len + nums.length - i > k && res[len - 1] < nums[i]) {
                len--;
            }
            if (len < k) {
                res[len] = nums[i];
                len++;
            }
        }
        return res;
    }
    
    private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        int p = 0;
        int q = 0;
        for (int i = 0; i < k; i++) {
            if (compare(nums1, p, nums2, q)) {
                res[i] = nums1[p];
                p++;
            } else {
                res[i] = nums2[q];
                q++;
            }
        }
        return res;
    }
    
    private boolean compare(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }
}
