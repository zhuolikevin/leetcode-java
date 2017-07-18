/*
 * [544] Output Contest Matches
 *
 * https://leetcode.com/problems/output-contest-matches
 *
 * Medium (72.56%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '4'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public String findContestMatch(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(String.valueOf(i));
        }
        
        while (list.size() > 1) {
            List<String> newList = new ArrayList<>();
            int left = 0;
            int right = list.size() - 1;
            StringBuilder sb = new StringBuilder();
            while (left < right) {
                sb.append("(" + list.get(left) + "," + list.get(right) + ")");
                newList.add(sb.toString());
                sb.setLength(0);
                left++;
                right--;
            }
            list = newList;
        }
        return list.get(0);
    }
}
