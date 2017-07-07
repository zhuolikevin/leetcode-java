/*
 * [605] Can Place Flowers
 *
 * https://leetcode.com/problems/can-place-flowers
 *
 * Easy (30.31%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,0,0,0,1]\n1'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 0) { return false; }
        
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) { continue; }
            if (canPlace(flowerbed, i)) {
                flowerbed[i] = 1;
                n--;
            }
        }
        
        return n <= 0;
    }
    
    private boolean canPlace(int[] flowerbed, int i) {
        if (flowerbed.length == 1) { return true; }
        if (i == 0) { return flowerbed.length > 1 && flowerbed[i+1] != 1; }
        else if (i == flowerbed.length - 1) { return flowerbed.length > 1 && flowerbed[i-1] != 1; }
        else { return flowerbed[i-1] != 1 && flowerbed[i+1] != 1; }
    }
}
