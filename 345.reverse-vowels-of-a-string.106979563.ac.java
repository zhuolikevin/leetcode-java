/*
 * [345] Reverse Vowels of a String
 *
 * https://leetcode.com/problems/reverse-vowels-of-a-string
 *
 * Easy (38.32%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"hello"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        int left = 0;
        int right = chars.length - 1;
        
        while (left < right && !set.contains(chars[left])) { left++; }
        while (right > left && !set.contains(chars[right])) { right--; }
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
            while (left < right && !set.contains(chars[left])) { left++; }
            while (right > left && !set.contains(chars[right])) { right--; }
        }
        
        return new String(chars);
    }
}
