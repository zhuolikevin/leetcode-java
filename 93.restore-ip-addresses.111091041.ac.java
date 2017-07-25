/*
 * [93] Restore IP Addresses
 *
 * https://leetcode.com/problems/restore-ip-addresses
 *
 * Medium (27.13%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"0000"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() > 12) {
            return res;
        }
        search(res, s, 0, 3, "");
        return res;
    }
    
    private void search(List<String> res, String s, int start, int dots, String curString) {
        if (dots == 0) {
            String remain = s.substring(start);
            if (remain.length() > 3) {
                return;
            }
            int number = Integer.parseInt(remain);
            if (number > 255 || !String.valueOf(number).equals(remain)) {
                return;
            }
            res.add(curString + remain);
            return;
        }
        
        for (int i = 1; i <= 3; i++) {
            if (start + i >= s.length() || i > 1 && s.charAt(start) == '0') {
                break;
            }
            int number = Integer.parseInt(s.substring(start, start + i));
            if (number <= 255) {
                search(res, s, start + i, dots - 1, curString + s.substring(start, start + i) + ".");
            }
        }
    }
}
