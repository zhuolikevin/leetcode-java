/*
 * [266] Palindrome Permutation
 *
 * https://leetcode.com/problems/palindrome-permutation
 *
 * Easy (56.66%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"aab"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public boolean canPermutePalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        int oddCount = 0;
        for (Character c : map.keySet()) {
            if (map.get(c) % 2 == 1) {
                if (oddCount == 1) {
                    return false;
                } else {
                    oddCount++;
                }
            }
        }
        
        return true;
    }
}
