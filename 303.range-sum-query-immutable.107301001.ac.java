/*
 * [303] Range Sum Query - Immutable
 *
 * https://leetcode.com/problems/range-sum-query-immutable
 *
 * Easy (28.94%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '["NumArray","sumRange","sumRange","sumRange"]\n[[[-2,0,3,-5,2,-1]],[0,2],[2,5],[0,5]]'
 *
 * Can you solve this problem? 🤔
 */
public class NumArray {
    private int[] sums;

    public NumArray(int[] nums) {
        sums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) { sums[i] = nums[i]; }
            else {
                sums[i] = sums[i - 1] + nums[i];
            }
        }
    }
    
    public int sumRange(int i, int j) {
        if (i == 0) { return sums[j]; }
        return sums[j] - sums[i - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
