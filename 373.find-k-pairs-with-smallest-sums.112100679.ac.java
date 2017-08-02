/*
 * [373] Find K Pairs with Smallest Sums
 *
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums
 *
 * Medium (30.62%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,7,11]\n[2,4,6]\n3'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return res;
        }
        
        Queue<int[]> pq = new PriorityQueue(k, new Comparator<int[]>() {
            @Override
            public int compare(int[] p, int[] q) {
                return p[0] + p[1] - q[0] - q[1];
            }
        });
        
        for (int i = 0; i < k && i < nums1.length; i++) {
            pq.offer(new int[] { nums1[i], nums2[0], 0 });
        }
        
        while (k > 0 && !pq.isEmpty()) {
            int[] candidates = pq.poll();
            res.add(new int[] { candidates[0], candidates[1] });
            k--;
            if (candidates[2] + 1 >= nums2.length) {
                continue;
            }
            pq.offer(new int[] { candidates[0], nums2[candidates[2] + 1], candidates[2] + 1 });
        }
        
        return res;
    }
}
