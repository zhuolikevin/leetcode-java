/*
 * [339] Nested List Weight Sum
 *
 * https://leetcode.com/problems/nested-list-weight-sum
 *
 * Easy (61.39%)
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
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    private int sum = 0;
    public int depthSum(List<NestedInteger> nestedList) {
        dfs(nestedList, 1);
        return sum;
    }
    
    private void dfs(List<NestedInteger> nestedList, int depth) {
        for (int i = 0; i < nestedList.size(); i++) {
            NestedInteger element = nestedList.get(i);
            if (element.isInteger()) {
                sum += element.getInteger() * depth;
            } else {
                dfs(element.getList(), depth + 1);
            }
        }
    }
}
