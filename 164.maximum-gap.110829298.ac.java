/*
 * [164] Maximum Gap
 *
 * https://leetcode.com/problems/maximum-gap
 *
 * Hard (29.40%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[]'
 *
 * Can you solve this problem? 🤔
 */
class Bucket {
    boolean used = false;
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
}
public class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        
        int minNum = Integer.MAX_VALUE;
        int maxNum = Integer.MIN_VALUE;
        for (int num : nums) {
            minNum = Math.min(minNum, num);
            maxNum = Math.max(maxNum, num);
        }
        
        int interval = Math.max(1, (maxNum - minNum) / (nums.length - 1));
        int bucketNum = (maxNum - minNum) / interval + 1;
        Bucket[] buckets = new Bucket[bucketNum];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new Bucket();
        }
        
        for (int num : nums) {
            int index = (num - minNum) / interval;
            buckets[index].used = true;
            buckets[index].min = Math.min(buckets[index].min, num);
            buckets[index].max = Math.max(buckets[index].max, num);
        }
        
        int maxGap = 0;
        Integer prevMax = null;
        for (Bucket bucket : buckets) {
            if (!bucket.used) {
                continue;
            }
            
            if (prevMax == null) {
                prevMax = bucket.max;
            } else {
                maxGap = Math.max(maxGap, bucket.min - prevMax);
                prevMax = bucket.max;
            }
        }
        
        return maxGap;
    }
}
