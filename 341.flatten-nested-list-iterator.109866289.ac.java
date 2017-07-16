/*
 * [341] Flatten Nested List Iterator
 *
 * https://leetcode.com/problems/flatten-nested-list-iterator
 *
 * Medium (41.11%)
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
public class NestedIterator implements Iterator<Integer> {
    private int curIndex;
    private List<NestedInteger> curList;
    private Stack<List<NestedInteger>> listStack;
    private Stack<Integer> indexStack;
    private Integer nextInt;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.curIndex = 0;
        this.curList = nestedList;
        this.listStack = new Stack<>();
        this.indexStack = new Stack<>();
        this.nextInt = searchNext();
    }
    
    private Integer searchNext() {
        if (curIndex < curList.size()) {
            NestedInteger curElement = curList.get(curIndex);
            if (curElement.isInteger()) {
                curIndex++;
                return curElement.getInteger();
            } else {
                listStack.push(curList);
                indexStack.push(curIndex);
                curList = curElement.getList();
                curIndex = 0;
                return searchNext();
            }
        } else {
            if (listStack.isEmpty()) {
                return null;
            }
            curList = listStack.pop();
            curIndex = indexStack.pop() + 1;
            return searchNext();
        }
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            return null;
        } else {
            Integer temp = nextInt;
            nextInt = searchNext();
            return temp;
        }
    }

    @Override
    public boolean hasNext() {
        return nextInt != null;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
