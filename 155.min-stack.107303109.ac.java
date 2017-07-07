/*
 * [155] Min Stack
 *
 * https://leetcode.com/problems/min-stack
 *
 * Easy (28.18%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '["MinStack","push","push","push","getMin","pop","top","getMin"]\n[[],[-2],[0],[-3],[],[],[],[]]'
 *
 * Can you solve this problem? 🤔
 */
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> mins;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        mins = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if (!mins.isEmpty()) {
            int curMin = mins.peek();
            if (x <= curMin) {
                mins.push(x);
            }
        } else {
            mins.push(x);
        }
    }
    
    public void pop() {
        if (!stack.isEmpty()) {
            int curNum = stack.peek();
            int curMin = mins.peek();
            stack.pop();
            if (curNum == curMin) {
                mins.pop();
            }
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return mins.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
