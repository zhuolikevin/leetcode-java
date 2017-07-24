/*
 * [573] Squirrel Simulation
 *
 * https://leetcode.com/problems/squirrel-simulation
 *
 * Medium (51.24%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '5\n7\n[2,2]\n[4,4]\n[[3,0], [2,5]]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        if (height <= 0 || width <= 0 || tree.length == 0 || squirrel.length == 0 || nuts.length == 0) {
            return 0;
        }
        
        int[] nutsToTree = new int[nuts.length];
        for (int i = 0; i < nuts.length; i++) {
            nutsToTree[i] = getDistance(nuts[i], tree);
        }
        
        int nearestNutIndex = -1;
        int nearestDistance = Integer.MAX_VALUE;
        for (int i = 0; i < nutsToTree.length; i++) {
            int toNut = getDistance(squirrel, nuts[i]);
            if (toNut - nutsToTree[i] < nearestDistance) {
                nearestNutIndex = i;
                nearestDistance = toNut - nutsToTree[i];
            }
        }
        
        int sum = 0;
        for (int i = 0; i < nutsToTree.length; i++) {            
            sum += 2 * nutsToTree[i];
        }
        
        return sum + nearestDistance;
    }
    
    private int getDistance(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
}
