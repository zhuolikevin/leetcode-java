/*
 * [421] Maximum XOR of Two Numbers in an Array
 *
 * https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array
 *
 * Medium (45.05%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[3,10,5,25,2,8]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int findMaximumXOR(int[] nums) {
        int mask = 0;
        int max = 0;
        for (int i = 31; i >= 0; i--) {
            mask |= (1 << i);
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num & mask);
            }
            int temp = max | (1 << i);
            for (int prefix : set) {
                if (set.contains(temp ^ prefix)) {
                    max = temp;
                    break;
                }
            }
        }
        return max;
    }
}
