/*
 * [565] Array Nesting
 *
 * https://leetcode.com/problems/array-nesting
 *
 * Medium (50.04%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[5,4,0,3,1,6,2]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int arrayNesting(int[] nums) {
        int maxSize = 0;
        Set<Integer> metNums = new HashSet<>();
        Set<Integer> curSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (metNums.contains(nums[i])) { continue; }
            int curNum = nums[i];
            while (!curSet.contains(curNum)) {
                curSet.add(curNum);
                metNums.add(curNum);
                curNum = nums[curNum];
            }
            maxSize = Math.max(maxSize, curSet.size());
            curSet.clear();
        }
        return maxSize;
    }
}
