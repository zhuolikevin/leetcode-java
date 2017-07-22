/*
 * [322] Coin Change
 *
 * https://leetcode.com/problems/coin-change
 *
 * Medium (26.48%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1]\n0'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] cache = new int[amount + 1];
        Arrays.fill(cache, -2);
        cache[0] = 0;
        return search(coins, amount, cache);
    }
    
    private int search(int[] coins, int amount, int[] cache) {
        if (cache[amount] != -2) {
            return cache[amount];
        }
        
        int min = Integer.MAX_VALUE;
        boolean find = false;
        for (int coin : coins) {
            if (coin <= amount) {
                int remain = search(coins, amount - coin, cache);
                if (remain != -1) {
                    min = Math.min(min, remain + 1);
                    find = true; 
                }
            }
        }
        cache[amount] = find ? min : -1;
        return cache[amount];
    }
}
