/*
 * [401] Binary Watch
 *
 * https://leetcode.com/problems/binary-watch
 *
 * Easy (44.84%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '0'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        
        for (int h = 0; h <= num; h++) {
            for (int i = 0; i <= 11; i++) {
                if (countOne(i) == h) {
                    String hour = String.valueOf(i);
                    for (int j = 0; j <= 59; j++) {
                        if (countOne(j) == num - h) {
                            String min;
                            if (j < 10) { min = "0" + String.valueOf(j); }
                            else { min = String.valueOf(j); }
                            res.add(hour + ":" + min);
                        }
                    }
                }
            }
        }
        
        return res;
    }
    
    private int countOne(int num) {
        int res = 0;
        while (num > 0) {
            res += num % 2;
            num = num / 2;
        }
        return res;
    }
}
