/*
 * [295] Find Median from Data Stream
 *
 * https://leetcode.com/problems/find-median-from-data-stream
 *
 * Hard (26.00%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]\n[[],[1],[2],[],[3],[]]'
 *
 * Can you solve this problem? 🤔
 */
public class MedianFinder {
    private Queue<Integer> minHeap;
    private Queue<Integer> maxHeap;

    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (minHeap.isEmpty() || num >= minHeap.peek()) {
            minHeap.offer(num);
        } else {
            maxHeap.offer(-num);
        }
        rebalance();
    }
    
    public double findMedian() {
        if (minHeap.size() - maxHeap.size() == 1) {
            return minHeap.peek();
        } else if (maxHeap.size() - minHeap.size() == 1) {
            return -maxHeap.peek();
        } else {
            return (minHeap.peek() - maxHeap.peek()) / 2.0;
        }
    }
    
    private void rebalance() {
        if (Math.abs(minHeap.size() - maxHeap.size()) > 1) {
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(-minHeap.poll());
            } else {
                minHeap.offer(-maxHeap.poll());
            }
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
