/*
 * [220] Contains Duplicate III
 *
 * https://leetcode.com/problems/contains-duplicate-iii
 *
 * Medium (19.11%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[]\n0\n0'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k < 0 || t < 0) {
            return false;
        }
        
        Map<Long, Long> buckToNum = new HashMap<>();
        long width = (long)t + 1;
        for (int i = 0; i < nums.length; i++) {
            long bucketNum = getBucketNum(nums[i], width);
            if (buckToNum.containsKey(bucketNum)) {
                return true;
            }
            if (buckToNum.containsKey(bucketNum - 1) && Math.abs(nums[i] - buckToNum.get(bucketNum - 1)) < width) {
                return true;
            }
            if (buckToNum.containsKey(bucketNum + 1) && Math.abs(nums[i] - buckToNum.get(bucketNum + 1)) < width) {
                return true;
            }
            buckToNum.put(bucketNum, (long)nums[i]);
            if (i >= k) {
                buckToNum.remove(getBucketNum(nums[i - k], width));
            }
        }
        
        return false;
    }
    
    private long getBucketNum(long num, long width) {
        return num < 0 ? (num + 1) / width - 1 : num / width;
    }
}
