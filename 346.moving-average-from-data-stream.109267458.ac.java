/*
 * [346] Moving Average from Data Stream
 *
 * https://leetcode.com/problems/moving-average-from-data-stream
 *
 * Easy (58.43%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '["MovingAverage","next","next","next","next"]\n[[3],[1],[10],[3],[5]]'
 *
 * Can you solve this problem? 🤔
 */
public class MovingAverage {
    int[] window;
    int index;
    int count;
    long sum;
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.window = new int[size];
        this.index = 0;
        this.count = 0;
        this.sum = 0;
    }
    
    public double next(int val) {
        if (count < window.length) {
            window[index] = val;
            index = (index + 1) % window.length;
            sum += (long)val;
            count++;
            return (double)sum / count;
        }
        
        sum -= (long)window[index];
        sum += (long)val;
        window[index] = val;
        index = (index + 1) % window.length;
        return (double)sum / window.length;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
