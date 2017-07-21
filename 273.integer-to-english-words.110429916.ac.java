/*
 * [273] Integer to English Words
 *
 * https://leetcode.com/problems/integer-to-english-words
 *
 * Hard (21.95%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '123'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};
    
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        
        String words = "";
        int count = 0;
        while (num > 0) {
            if (num % 1000 != 0) {
                words = helper(num % 1000) + THOUSANDS[count] + " " + words;
            }
            num = num / 1000;
            count++;
        }
        
        return words.trim();
    }
    
    private String helper(int num) {
        if (num >= 100) {
            return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100); 
        } else if (num >= 20) {
            return TENS[num / 10] + " " + helper(num % 10);
        } else if (num > 0 ) {
            return LESS_THAN_20[num] + " ";
        } else {
            return "";
        }
    }
}
