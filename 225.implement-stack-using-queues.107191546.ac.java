/*
 * [225] Implement Stack using Queues
 *
 * https://leetcode.com/problems/implement-stack-using-queues
 *
 * Easy (32.56%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '["MyStack","empty"]\n[[],[]]'
 *
 * Can you solve this problem? 🤔
 */
public class MyStack {
    private Queue<Integer> queue;

    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        int count = queue.size();
        while (count > 1) {
            queue.add(queue.poll());
            count--;
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return queue.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.size() == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
