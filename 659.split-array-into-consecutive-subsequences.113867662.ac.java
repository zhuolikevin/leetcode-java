/*
 * [659] Split Array into Consecutive Subsequences
 *
 * https://leetcode.com/problems/split-array-into-consecutive-subsequences
 *
 * Medium (32.22%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,2,3,3,4,5]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> appendFreq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        for (int num : nums) {
            if (freq.get(num) == 0) {
                continue;
            }
            
            if (appendFreq.getOrDefault(num, 0) > 0) {
                appendFreq.put(num, appendFreq.get(num) - 1);
                appendFreq.put(num + 1, appendFreq.getOrDefault(num + 1, 0) + 1);
            } else if (freq.getOrDefault(num + 1, 0) > 0 && freq.getOrDefault(num + 2, 0) > 0) {
                freq.put(num + 1, freq.get(num + 1) - 1);
                freq.put(num + 2, freq.get(num + 2) - 1);
                appendFreq.put(num + 3, appendFreq.getOrDefault(num + 3, 0) + 1);
            } else {
                return false;
            }
            
            freq.put(num, freq.get(num) - 1);
        }
        
        return true;
    }
}
