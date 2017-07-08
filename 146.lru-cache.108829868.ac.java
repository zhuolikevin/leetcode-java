/*
 * [146] LRU Cache
 *
 * https://leetcode.com/problems/lru-cache
 *
 * Hard (17.38%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '["LRUCache","put","put","get","put","get","put","get","get","get"]\n[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]'
 *
 * Can you solve this problem? 🤔
 */
class DoubleListNode {
    int key;
    int val;
    DoubleListNode next;
    DoubleListNode prev;
    DoubleListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

public class LRUCache {
    private Map<Integer, DoubleListNode> map;
    private DoubleListNode head;
    private DoubleListNode tail;
    private int count;
    private int capacity;

    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new DoubleListNode(-1, -1);
        this.tail = new DoubleListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        
        DoubleListNode target = map.get(key);
        moveToHead(target);
        
        return map.get(key).val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DoubleListNode target = map.get(key);
            target.val = value;
            moveToHead(target);
            return;
        }
        
        DoubleListNode target = new DoubleListNode(key, value);
        head.next.prev = target;
        target.next = head.next;
        head.next = target;
        target.prev = head;
        map.put(key, target);
        
        if (count < capacity) {
            count++;
        } else {
            DoubleListNode delete = tail.prev;
            map.remove(delete.key);
            delete.prev.next = tail;
            tail.prev = delete.prev;
        }
    }
    
    private void moveToHead(DoubleListNode target) {
        target.prev.next = target.next;
        target.next.prev = target.prev;
        
        head.next.prev = target;
        target.next = head.next;
        head.next = target;
        target.prev = head;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
