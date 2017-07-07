/*
 * [575] Distribute Candies
 *
 * https://leetcode.com/problems/distribute-candies
 *
 * Easy (59.43%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,1,2,2,3,3]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int distributeCandies(int[] candies) {
        int n = candies.length;
        HashSet<Integer> set = new HashSet<>();
        for (int candy : candies) {
            set.add(candy);
        }
        
        return Math.min(n / 2, set.size());
    }
}
