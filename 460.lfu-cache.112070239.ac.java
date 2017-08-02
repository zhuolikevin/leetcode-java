/*
 * [460] LFU Cache
 *
 * https://leetcode.com/problems/lfu-cache
 *
 * Hard (23.44%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '["LFUCache","put","put","get","put","get","get","put","get","get","get"]\n[[2],[1,1],[2,2],[1],[3,3],[2],[3],[4,4],[1],[3],[4]]'
 *
 * Can you solve this problem? 🤔
 */
public class LFUCache {
    Map<Integer, Integer> store;
    Map<Integer, Integer> freq;
    Map<Integer, LinkedHashSet<Integer>> freqs;
    int capacity;
    int minFreq;

    public LFUCache(int capacity) {
        this.store = new HashMap<>();
        this.freq = new HashMap<>();
        this.freqs = new HashMap<>();
        this.capacity = capacity;
        this.minFreq = 1;
        this.freqs.put(1, new LinkedHashSet<>());
    }
    
    public int get(int key) {
        if (store.containsKey(key)) {
            increaseFreq(key);
            return store.get(key);
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }
        
        if (store.containsKey(key)) {
            store.put(key, value);
            increaseFreq(key);
            return;
        }
        if (store.size() >= capacity) {
            int evit = freqs.get(minFreq).iterator().next();
            freqs.get(minFreq).remove(evit);
            store.remove(evit);
            freq.remove(evit);
        }
        store.put(key, value);
        freq.put(key, 1);
        freqs.get(1).add(key);
        minFreq = 1;
    }
    
    private void increaseFreq(int key) {
        int curFreq = freq.get(key);
        freq.put(key, curFreq + 1);
        freqs.get(curFreq).remove(key);
        if (!freqs.containsKey(curFreq + 1)) {
            freqs.put(curFreq + 1, new LinkedHashSet<>());
        }
        freqs.get(curFreq + 1).add(key);
        if (curFreq == minFreq && freqs.get(curFreq).isEmpty()) {
            minFreq = curFreq + 1;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
