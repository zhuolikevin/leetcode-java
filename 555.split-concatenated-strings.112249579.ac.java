/*
 * [555] Split Concatenated Strings
 *
 * https://leetcode.com/problems/split-concatenated-strings
 *
 * Medium (34.29%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '["abc","xyz"]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public String splitLoopedString(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        for (int i = 0; i < strs.length; i++) {
            String reversed = new StringBuilder(strs[i]).reverse().toString();
            if (reversed.compareTo(strs[i]) > 0) {
                strs[i] = reversed;
            }
        }
        
        String res = null;
        for (int i = 0; i < strs.length; i++) {
            String reversed = new StringBuilder(strs[i]).reverse().toString();
            for (String st : new String[] { strs[i], reversed }) {
                for (int j = 0; j < st.length(); j++) {
                    StringBuilder sb = new StringBuilder(st.substring(j));
                    for (int k = i + 1; k < strs.length; k++) {
                        sb.append(strs[k]);
                    }
                    for (int k = 0; k < i; k++) {
                        sb.append(strs[k]);
                    }
                    sb.append(st.substring(0, j));
                    
                    String newConcat = sb.toString();
                    if (res == null || newConcat.compareTo(res) > 0) {
                        res = newConcat;
                    }
                }
            }
        }
        
        return res;
    }
}
