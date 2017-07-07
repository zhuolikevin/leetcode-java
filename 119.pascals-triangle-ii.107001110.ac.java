/*
 * [119] Pascal's Triangle II
 *
 * https://leetcode.com/problems/pascals-triangle-ii
 *
 * Easy (36.44%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '0'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> lastLevel = new ArrayList<>();
        if (rowIndex < 0) { return lastLevel; }
        lastLevel.add(1);
        if (rowIndex == 0) { return lastLevel; }
        
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> thisLevel = new ArrayList<>();
            thisLevel.add(1);
            for (int j = 1; j < i; j++) {
                thisLevel.add(lastLevel.get(j-1) + lastLevel.get(j));
            }
            thisLevel.add(1);
            lastLevel = thisLevel;
        }
        
        return lastLevel;
    }
}
