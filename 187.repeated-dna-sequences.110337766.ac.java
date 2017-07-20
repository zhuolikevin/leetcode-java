/*
 * [187] Repeated DNA Sequences
 *
 * https://leetcode.com/problems/repeated-dna-sequences
 *
 * Medium (31.18%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() <= 10) {
            return res;
        }
        
        Set<String> set = new HashSet<>();
        Set<String> added = new HashSet<>();
        for (int i = 10; i <= s.length(); i++) {
            String sub = s.substring(i - 10, i);
            if (set.contains(sub) && !added.contains(sub)) {
                res.add(sub);
                added.add(sub);
            } else {
                set.add(sub);
            }
        }
        
        return res;
    }
}
