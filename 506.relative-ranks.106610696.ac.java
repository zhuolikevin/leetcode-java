/*
 * [506] Relative Ranks
 *
 * https://leetcode.com/problems/relative-ranks
 *
 * Easy (46.66%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[5,4,3,2,1]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(new int[]{ nums[i], i });
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return b[0] - a[0];
            }
        });
        String[] res = new String[nums.length];
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) res[list.get(i)[1]] = "Gold Medal";
            else if (i == 1) res[list.get(i)[1]] = "Silver Medal";
            else if (i == 2) res[list.get(i)[1]] = "Bronze Medal";
            else res[list.get(i)[1]] = String.valueOf(i + 1);
        }
        return res;
    }
}
