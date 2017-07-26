/*
 * [267] Palindrome Permutation II
 *
 * https://leetcode.com/problems/palindrome-permutation-ii
 *
 * Medium (31.76%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"aabb"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        int[] lib = new int[256];
        if (!isPalinPermu(s, lib)) {
            return res;
        }
        
        search(res, lib, s.length(), "", "");
        return res;
    }
    
    private void search(List<String> res, int[] lib, int count, String leftString, String rightString) {
        if (count == 0) {
            res.add(leftString + rightString);
            return;
        }
        
        if (count == 1) {
            for (int i = 0; i < lib.length; i++) {
                if (lib[i] == 1) {
                    res.add(leftString + String.valueOf((char)(i)) + rightString);
                    return;
                }
            }
        }
        
        for (int i = 0; i < lib.length; i++) {
            if (lib[i] >= 2) {
                String letter = String.valueOf((char)(i));
                lib[i] -= 2;
                search(res, lib, count - 2, leftString + letter, letter + rightString);
                lib[i] += 2;
            }
        }
    }
    
    private boolean isPalinPermu(String s, int[] lib) {
        for (int i = 0; i < s.length(); i++) {
            lib[s.charAt(i)]++;
        }
        boolean odd = false;
        for (int i = 0; i < lib.length; i++) {
            if (lib[i] % 2 == 1) {
                if (odd) {
                    return false;
                } else {
                    odd = true;
                }
            }
        }
        return true;
    }
}
