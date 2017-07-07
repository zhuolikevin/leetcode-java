/*
 * [383] Ransom Note
 *
 * https://leetcode.com/problems/ransom-note
 *
 * Easy (46.95%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"a"\n"b"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] note = ransomNote.toCharArray();
        char[] maga = magazine.toCharArray();
        for (char letter : maga) {
            map.put(letter, map.getOrDefault(letter, 0) + 1);
        }
        for (char letter : note) {
            if (map.get(letter) != null && map.get(letter) > 0) {
                map.put(letter, map.get(letter) - 1);
            } else {
                return false;
            }
        }
        return true;
    }
}
