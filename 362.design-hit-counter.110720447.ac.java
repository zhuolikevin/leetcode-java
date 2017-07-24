/*
 * [362] Design Hit Counter
 *
 * https://leetcode.com/problems/design-hit-counter
 *
 * Medium (53.55%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '["HitCounter","hit","hit","hit","getHits","hit","getHits","getHits"]\n[[],[1],[2],[3],[4],[300],[300],[301]]'
 *
 * Can you solve this problem? 🤔
 */
public class HitCounter {
    private Queue<Integer> queue;
    private Map<Integer, Integer> map;
    private int count;

    /** Initialize your data structure here. */
    public HitCounter() {
        this.queue = new LinkedList<>();
        this.map = new HashMap<>();
        this.count = 0;
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        while (!queue.isEmpty() && timestamp - queue.peek() >= 300) {
            count -= map.get(queue.peek());
            map.remove(queue.peek());
            queue.poll();
        }
        if (!map.containsKey(timestamp)) {
            queue.offer(timestamp);
        }
        map.put(timestamp, map.getOrDefault(timestamp, 0) + 1);
        count += 1;
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while (!queue.isEmpty() && timestamp - queue.peek() >= 300) {
            count -= map.get(queue.peek());
            map.remove(queue.peek());
            queue.poll();
        }
        return count;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
