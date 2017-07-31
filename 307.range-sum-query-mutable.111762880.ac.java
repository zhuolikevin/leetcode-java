/*
 * [307] Range Sum Query - Mutable
 *
 * https://leetcode.com/problems/range-sum-query-mutable
 *
 * Medium (20.37%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '["NumArray","sumRange","update","sumRange"]\n[[[1,3,5]],[0,2],[1,2],[0,2]]'
 *
 * Can you solve this problem? 🤔
 */
public class NumArray {
    private int[] tree;
    private int n;
    
    public NumArray(int[] nums) {
        n = nums.length;
        if (n > 0) {
            int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
            int maxSize = 2 * (int) Math.pow(2, x) - 1;
            tree = new int[maxSize];
            buildTree(nums, 0, 0, n - 1);
        }
    }
    
    private void buildTree(int[] nums, int treeIndex, int left, int right) {
        if (left == right) {
            tree[treeIndex] = nums[left];
            return;
        }
        
        int mid = left + (right - left) / 2;
        buildTree(nums, treeIndex * 2 + 1, left, mid);
        buildTree(nums, treeIndex * 2 + 2, mid + 1, right);
        tree[treeIndex] = tree[treeIndex * 2 + 1] + tree[treeIndex * 2 + 2];
    }
    
    private void updateTree(int left, int right, int treeIndex, int i, int val) {
        if (left == right) {
            tree[treeIndex] = val;
            return;
        }
        
        int mid = left + (right - left) / 2;
        if (i <= mid) {
            updateTree(left, mid, treeIndex * 2 + 1, i, val);
        } else {
            updateTree(mid + 1, right, treeIndex * 2 + 2, i, val);
        }
        tree[treeIndex] = tree[treeIndex * 2 + 1] + tree[treeIndex * 2 + 2];
    }
    
    private int query(int left, int right, int i, int j, int treeIndex) {
        if (j < left || i > right) {
            return 0;
        }
        if (i <= left && j >= right) {
            return tree[treeIndex];
        }
        
        int mid = left + (right - left) / 2;
        if (j <= mid) {
            return query(left, mid, i, j, treeIndex * 2 + 1);
        } else if (i > mid) {
            return query(mid + 1, right, i, j, treeIndex * 2 + 2);
        } else {
            return query(left, mid, i, j, treeIndex * 2 + 1) + query(mid + 1, right, i, j, treeIndex * 2 + 2);
        }
    }
    
    public void update(int i, int val) {
        updateTree(0, n - 1, 0, i, val);
    }
    
    public int sumRange(int i, int j) {
        return query(0, n - 1, i, j, 0);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
