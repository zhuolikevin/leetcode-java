/*
 * [379] Design Phone Directory
 *
 * https://leetcode.com/problems/design-phone-directory
 *
 * Medium (32.13%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '["PhoneDirectory","get","get","check","get","check","release","check"]\n[[3],[],[],[2],[],[2],[2],[2]]'
 *
 * Can you solve this problem? 🤔
 */
public class PhoneDirectory {
    Set<Integer> set;
    Queue<Integer> queue;
    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        this.set = new HashSet<>();
        this.queue = new LinkedList<>();
        for (int i = 0; i < maxNumbers; i++) {
            queue.offer(i);
            set.add(i);
        }
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (queue.size() == 0) {
            return -1;
        }
        int num = queue.poll();
        set.remove(num);
        return num;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return set.contains(number);    
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        queue.offer(number);
        set.add(number);
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */
