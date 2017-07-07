/*
 * [232] Implement Queue using Stacks
 *
 * https://leetcode.com/problems/implement-queue-using-stacks
 *
 * Easy (36.39%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '["MyQueue","empty"]\n[[],[]]'
 *
 * Can you solve this problem? 🤔
 */
public class MyQueue {
    private Stack<Integer> inputStack;
    private Stack<Integer> outputStack;

    /** Initialize your data structure here. */
    public MyQueue() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        inputStack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!outputStack.isEmpty()) {
            return outputStack.pop();
        } else {
            transferStack();
            return outputStack.pop();
        }
    }
    
    /** Get the front element. */
    public int peek() {
        if (outputStack.isEmpty()) {
            transferStack();
        }
        return outputStack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }
    
    private void transferStack() {
        while (!inputStack.isEmpty()) {
            outputStack.push(inputStack.pop());
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
