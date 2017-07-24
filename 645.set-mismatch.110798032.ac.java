/*
 * [645] Set Mismatch
 *
 * https://leetcode.com/problems/set-mismatch
 *
 * Easy (41.74%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,2,2,4]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        boolean[] arr = new boolean[nums.length];
        for (int num : nums) {
            if (arr[num - 1]) {
                res[0] = num;
            } else {
                arr[num - 1] = true;
            }
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i]) {
                res[1] = i + 1;
            }
        }
        
        return res;
    }
}
