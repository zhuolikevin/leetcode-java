/*
 * [299] Bulls and Cows
 *
 * https://leetcode.com/problems/bulls-and-cows
 *
 * Medium (34.59%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"1807"\n"7810"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public String getHint(String secret, String guess) {
        int bull = 0;
        int cow = 0;
        Map<Character, Integer> dict = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < secret.length(); i++) {
            char charS = secret.charAt(i);
            char charG = guess.charAt(i);
            if (charS == charG) {
                bull++;
                set.add(i);
            }
        }
        for (int i = 0; i < secret.length(); i++) {
            char charS = secret.charAt(i);
            if (set.contains(i)) {
                continue;
            }
            dict.put(charS, dict.getOrDefault(charS, 0) + 1);
        }
        for (int i = 0; i < guess.length(); i++) {
            char charG = guess.charAt(i);
            if (set.contains(i)) {
                continue;
            }
            if (dict.containsKey(charG) && dict.get(charG) > 0) {
                cow++;
                dict.put(charG, dict.get(charG) - 1);
            }
        }
        
        return String.valueOf(bull) + "A" + String.valueOf(cow) + "B";
    }
}
