/*
 * [239] Sliding Window Maximum
 *
 * https://leetcode.com/problems/sliding-window-maximum
 *
 * Hard (32.72%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[]\n0'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        
        List<Integer> res = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i = 0; i < Math.min(nums.length, k); i++) {
            while (!deque.isEmpty() && nums[i] > deque.peekFirst()) {
                deque.pollFirst();
            }
            deque.offerFirst(nums[i]);
        }
        res.add(deque.peekLast());
        
        int left = 0;
        int right = k;
        while (right < nums.length) {
            if (nums[left] == deque.peekLast()) {
                deque.pollLast();
            }
            left++;
            while (!deque.isEmpty() && nums[right] > deque.peekFirst()) {
                deque.pollFirst();
            }
            deque.offerFirst(nums[right]);
            right++;
            res.add(deque.peekLast());
        }
        
        int resArr[] = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArr[i] = res.get(i);
        }
        return resArr;
    }
}
