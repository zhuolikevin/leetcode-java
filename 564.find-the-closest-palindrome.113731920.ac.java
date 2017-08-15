/*
 * [564] Find the Closest Palindrome
 *
 * https://leetcode.com/problems/find-the-closest-palindrome
 *
 * Hard (16.84%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '"1"'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public String nearestPalindromic(String n) {
        if (n.equals("1")) {
            return "0";
        }
        String palin1 = mirror(n);
        long diff1 = Math.abs(Long.parseLong(n) - Long.parseLong(palin1));
        
        if (diff1 == 0) {
            diff1 = Long.MAX_VALUE;
        }
        
        String palin2 = getDeducted(n);
        long diff2 = Math.abs(Long.parseLong(n) - Long.parseLong(palin2));
        
        String palin3 = getPlused(n);
        long diff3 = Math.abs(Long.parseLong(n) - Long.parseLong(palin3));
        
        if (diff2 <= diff1 && diff2 <= diff3) {
            return palin2;
        } else if (diff1 <= diff3) {
            return palin1;
        } else {
            return palin3;
        }
    }
    
    private String getDeducted(String str) {
        StringBuilder sb = new StringBuilder(str);
        int i = (str.length() - 1) / 2;
        while (i >= 0 && sb.charAt(i) == '0') {
            sb.setCharAt(i, '9');
            i--;
        }
        
        if (i == 0 && sb.charAt(i) == '1') {
            sb.delete(0, 1);
            int mid = (sb.length() - 1) / 2;
            sb.setCharAt(mid, '9');
        } else {
            sb.setCharAt(i, (char)(sb.charAt(i) - 1));
        }
        
        return mirror(sb.toString());
    }
    
    private String getPlused(String str) {
        StringBuilder sb = new StringBuilder(str);
        int i = (str.length() - 1) / 2;
        while (i >= 0 && sb.charAt(i) == '9') {
            sb.setCharAt(i, '0');
            i--;
        }
        
        if (i < 0) {
            sb.insert(0, '1');
        } else {
            sb.setCharAt(i, (char)(sb.charAt(i) + 1));
        }
        
        return mirror(sb.toString());
    }
    
    private String mirror(String str) {
        int len = str.length();
        StringBuilder sb = new StringBuilder();
        String half = str.substring(0, len / 2);
        if (len % 2 == 0) {
            return half + sb.append(half).reverse();
        } else {
            return half + str.substring(len / 2, len / 2 + 1) + sb.append(half).reverse();
        }
    }
}
