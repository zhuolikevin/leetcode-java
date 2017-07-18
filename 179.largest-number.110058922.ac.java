/*
 * [179] Largest Number
 *
 * https://leetcode.com/problems/largest-number
 *
 * Medium (22.43%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    private Comparator<String> comparator = new Comparator<String>() {
        @Override
        public int compare(String s1, String s2) {
            String res1 = s1 + s2;
            String res2 = s2 + s1;
            return res2.compareTo(res1);
        }
    };
    
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        
        Arrays.sort(strs, comparator);
        
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        String res = sb.toString();
        int index = 0;
        while (index < res.length() && res.charAt(index) == '0') {
            index++;
        }
        return index == res.length() ? "0" : res.substring(index);
    }
}
