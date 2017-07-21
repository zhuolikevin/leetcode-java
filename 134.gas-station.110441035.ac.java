/*
 * [134] Gas Station
 *
 * https://leetcode.com/problems/gas-station
 *
 * Medium (29.20%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[4]\n[5]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0 || cost == null || cost.length == 0 || gas.length != cost.length) {
            return -1;
        }
        
        int totalGas = 0;
        int totalCost = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }
        
        if (totalCost > totalGas) {
            return -1;
        }
        
        int count = 0;
        int tank = 0;
        int i = 0;
        int start = i;
        while (count < gas.length) {
            tank = tank + gas[i] - cost[i];
            if (tank < 0) {
                start = (i + 1) % gas.length;
                count = 0;
                tank = 0;
            } else {
                count++;
            }
            i = (i + 1) % gas.length;
        }
        
        return start;
    }
}
