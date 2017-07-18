/*
 * [223] Rectangle Area
 *
 * https://leetcode.com/problems/rectangle-area
 *
 * Medium (32.75%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '-2\n-2\n2\n2\n-2\n-2\n2\n2'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int length1 = C - A;
        int length2 = G - E;
        int width1 = D - B;
        int width2 = H - F;
        int area1 = length1 * width1;
        int area2 = length2 * width2;
        
        if (C <= E || G <= A || B >= H || F >= D) {
            return area1 + area2;
        }
        
        int length = Math.min(C, G) - Math.max(A, E);
        int width = Math.min(D, H) - Math.max(B, F);
        return area1 + area2 - length * width;
    }
}
