/*
 * [378] Kth Smallest Element in a Sorted Matrix
 *
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix
 *
 * Medium (44.29%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[[1,5,9],[10,11,13],[12,13,15]]\n8'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        for (int j = 0; j < m; j++) {
            pq.offer(new Tuple(0, j, matrix[0][j]));
        }
        
        for (int i = 1; i < k; i++) {
            Tuple curTuple = pq.poll();
            if (curTuple.x == n - 1) { continue; }
            pq.offer(new Tuple(curTuple.x + 1, curTuple.y, matrix[curTuple.x + 1][curTuple.y]));
        }
        return pq.poll().val;
    }
}

class Tuple implements Comparable<Tuple> {
    int x, y, val;
    public Tuple(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
    
    @Override
    public int compareTo(Tuple that) {
        return this.val - that.val;
    }
}
