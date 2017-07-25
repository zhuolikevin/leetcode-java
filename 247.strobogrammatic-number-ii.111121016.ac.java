/*
 * [247] Strobogrammatic Number II
 *
 * https://leetcode.com/problems/strobogrammatic-number-ii
 *
 * Medium (39.63%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '2'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
        search(res, n, true, "", "");
        return res;
    }
    
    private void search(List<String> res, int n, boolean edge, String curLeft, String curRight) {
        if (n == 0) {
            res.add(curLeft + curRight);
            return;
        }
        if (n == 1) {
            res.add(curLeft + "0" + curRight);
            res.add(curLeft + "1" + curRight);
            res.add(curLeft + "8" + curRight);
            return;
        }
        
        if (!edge) {
            search(res, n - 2, false, curLeft + "0", "0" + curRight);
        }
        search(res, n - 2, false, curLeft + "1", "1" + curRight);
        search(res, n - 2, false, curLeft + "6", "9" + curRight);
        search(res, n - 2, false, curLeft + "8", "8" + curRight);
        search(res, n - 2, false, curLeft + "9", "6" + curRight);
    }
}
