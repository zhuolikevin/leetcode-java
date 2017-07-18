/*
 * [313] Super Ugly Number
 *
 * https://leetcode.com/problems/super-ugly-number
 *
 * Medium (37.59%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '1\n[2,3,5]'
 *
 * Can you solve this problem? 🤔
 */
class Factor implements Comparable<Factor> {
    int val;
    int index;
    Factor(int val, int index) {
        this.val = val;
        this.index = index;
    }
    @Override
    public int compareTo(Factor that) {
        return this.val - that.val;
    }
}
public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int[] indices = new int[primes.length];
        Queue<Factor> pq = new PriorityQueue();
        for (int i = 0; i < primes.length; i++) {
            pq.offer(new Factor(primes[i], i));
        }
        
        for (int i = 1; i < n; i++) {
            int nextVal = pq.peek().val;
            ugly[i] = nextVal;
            while (pq.peek().val == nextVal) {
                Factor f = pq.poll();
                indices[f.index]++;
                pq.offer(new Factor(primes[f.index] * ugly[indices[f.index]], f.index));
            }
        }
        
        return ugly[n - 1];
    }
}
