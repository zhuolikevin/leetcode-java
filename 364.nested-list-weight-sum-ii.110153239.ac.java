/*
 * [364] Nested List Weight Sum II
 *
 * https://leetcode.com/problems/nested-list-weight-sum-ii
 *
 * Medium (51.94%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[[1,1],2,[1,1]]'
 *
 * Can you solve this problem? 🤔
 */
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    private int sum = 0;
    private int maxDepth = 0;
    public int depthSumInverse(List<NestedInteger> nestedList) {
        findDepth(nestedList, 1);
        dfs(nestedList, maxDepth);
        return sum;
    }
    
    private void findDepth(List<NestedInteger> nestedList, int depth) {
        maxDepth = Math.max(maxDepth, depth);
        for (int i = 0; i < nestedList.size(); i++) {
            NestedInteger element = nestedList.get(i);
            if (!element.isInteger()) {
                findDepth(element.getList(), depth + 1);
            }
        }
    }
    
    private void dfs(List<NestedInteger> nestedList, int depth) {
        for (int i = 0; i < nestedList.size(); i++) {
            NestedInteger element = nestedList.get(i);
            if (element.isInteger()) {
                sum += element.getInteger() * depth;
            } else {
                dfs(element.getList(), depth - 1);
            }
        }
    }
}
