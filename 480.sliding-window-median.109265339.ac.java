/*
 * [480] Sliding Window Median
 *
 * https://leetcode.com/problems/sliding-window-median
 *
 * Hard (31.49%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,3,-1,-3,5,3,6,7]\n3'
 *
 * Can you solve this problem? 🤔
 */
class MedianFinder {
    private Queue<Long> minHeap;
    private Queue<Long> maxHeap;
    
    MedianFinder() {
        this.minHeap = new PriorityQueue<>();
        this.maxHeap = new PriorityQueue<>();
    }
    
    public void insert(int num) {
        if (minHeap.isEmpty() || num >= minHeap.peek()) {
            minHeap.offer((long)num);
        } else {
            maxHeap.offer(-(long)num);
        }
        reblance();
    }
    
    public void remove(int num) {
        if (num >= minHeap.peek()) {
            minHeap.remove((long)num);
        } else if (num < minHeap.peek()) {
            maxHeap.remove(-(long)num);
        }
        reblance();
    }
    
    public double getMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return (double)(minHeap.peek() - maxHeap.peek()) / 2.0;
        } else {
            return (double)minHeap.peek();
        }
    }
    
    private void reblance() {
        int minSize = minHeap.size();
        int maxSize = maxHeap.size();
        if (minSize - maxSize > 1) {
            maxHeap.offer(-minHeap.poll());
        } else if (minSize < maxSize) {
            minHeap.offer(-maxHeap.poll());
        }
    }
}
public class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return new double[0];
        }
        
        
        List<Double> res = new ArrayList<>();
        MedianFinder mf = new MedianFinder();
        for (int i = 0; i < nums.length && i < k; i++) {
            mf.insert(nums[i]);
        }
        res.add(mf.getMedian());
        
        int left = 0;
        int right = k;
        while (right < nums.length) {
            mf.insert(nums[right]);
            mf.remove(nums[left]);
            res.add(mf.getMedian());
            right++;
            left++;
        }
        
        double[] resArr = new double[res.size()];
        for (int i = 0; i < resArr.length; i++) {
            resArr[i] = res.get(i);
        }
        return resArr;
    }
}
