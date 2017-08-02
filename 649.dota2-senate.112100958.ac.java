/*
 * [649] Dota2 Senate
 *
 * https://leetcode.com/problems/dota2-senate
 *
 * Medium (32.34%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"RD"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public String predictPartyVictory(String senate) {
        if (senate.length() == 1) {
            return senate.equals("D") ? "Dire" : "Radiant";
        }
        
        char[] round = senate.toCharArray();
        boolean[] alive = new boolean[round.length];
        Arrays.fill(alive, true);
        for (int i = 0; i < round.length; i++) {
            if (!alive[i]) {
                continue;
            }
            if (round[i] == 'R') {
                boolean find = false;
                for (int j = i + 1; j < round.length; j++) {
                    if (alive[j] && round[j] == 'D') {
                        find = true;
                        alive[j] = false;
                        break;
                    }
                }
                if (!find) {
                    for (int j = 0; j < i; j++) {
                        if (alive[j] && round[j] == 'D') {
                            find = true;
                            alive[j] = false;
                            break;
                        }
                    }
                }
                if (!find) {
                    return "Radiant";
                }
            }
            if (round[i] == 'D') {
                boolean find = false;
                for (int j = i + 1; j < round.length; j++) {
                    if (alive[j] && round[j] == 'R') {
                        find = true;
                        alive[j] = false;
                        break;
                    }
                }
                if (!find) {
                    for (int j = 0; j < i; j++) {
                        if (alive[j] && round[j] == 'R') {
                            find = true;
                            alive[j] = false;
                            break;
                        }
                    }
                }
                if (!find) {
                    return "Dire";
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < round.length; i++) {
            if (alive[i]) {
                sb.append(round[i]);
            }
        }
        return predictPartyVictory(sb.toString());
    }
}
