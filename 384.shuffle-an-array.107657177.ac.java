/*
 * [384] Shuffle an Array
 *
 * https://leetcode.com/problems/shuffle-an-array
 *
 * Medium (46.24%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '["Solution","shuffle","reset","shuffle"]\n[[[1,2,3]],[],[],[]]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    private int[] origin;

    public Solution(int[] nums) {
        origin = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return origin;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Random rand = new Random();
        int[] res = origin.clone();
        for (int i = res.length - 1; i >= 0; i--) {
            int randIndex = rand.nextInt(i + 1);
            int temp = res[randIndex];
            res[randIndex] = res[i];
            res[i] = temp;
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
