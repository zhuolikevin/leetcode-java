/*
 * [406] Queue Reconstruction by Height
 *
 * https://leetcode.com/problems/queue-reconstruction-by-height
 *
 * Medium (55.23%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] > b[0]) { return -1; }
                else if (a[0] == b[0] && a[1] < b[1]) { return -1; }
                else if (a[0] == b[0] && a[1] == b[1]) { return 0; }
                else { return 1; }
            }
        });
        
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            res.add(people[i][1], people[i]);
        }
        return res.toArray(new int[people.length][]);
    }
}
