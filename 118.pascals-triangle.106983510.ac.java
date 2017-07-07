/*
 * [118] Pascal's Triangle
 *
 * https://leetcode.com/problems/pascals-triangle
 *
 * Easy (38.17%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '0'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) { return res; }
        List<Integer> level1 = new ArrayList<>();
        level1.add(1);
        res.add(level1);
        if (numRows == 1) { return res; }
        
        for (int i = 2; i <= numRows; i++) {
            List<Integer> thisLevel = new ArrayList<>();
            thisLevel.add(1);
            List<Integer> lastLevel = res.get(i - 2);
            for (int j = 1; j < i - 1; j++) {
                thisLevel.add(lastLevel.get(j-1) + lastLevel.get(j));
            }
            thisLevel.add(1);
            res.add(thisLevel);
        }
        
        return res;
    }
}
