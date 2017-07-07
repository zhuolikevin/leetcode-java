/*
 * [318] Maximum Product of Word Lengths
 *
 * https://leetcode.com/problems/maximum-product-of-word-lengths
 *
 * Medium (43.84%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '["abcw","baz","foo","bar","xtfn","abcdef"]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int maxProduct(String[] words) {
        int len = words.length;
        int[] value = new int[len];
        for (int i = 0; i < len; i++) {
            String temp = words[i];
            value[i] = 0;
            for (int j = 0; j < temp.length(); j++) {
                value[i] |= (1 << temp.charAt(j) - 'a');
            }
        }
        int maxProd = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((value[i] & value[j]) != 0) { continue; }
                maxProd = Math.max(maxProd, words[i].length() * words[j].length());
            }
        }
        return maxProd;
    }
}
