/*
 * [302] Smallest Rectangle Enclosing Black Pixels
 *
 * https://leetcode.com/problems/smallest-rectangle-enclosing-black-pixels
 *
 * Hard (45.09%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '["0010","0110","0100"]\n0\n2'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int minArea(char[][] image, int x, int y) {
        if (image == null || image.length == 0 || image[0].length == 0) {
            return 0;
        }
        int leftMost = findLeft(image, y);
        int rightMost = findRight(image, y);
        int upMost = findUp(image, x);
        int downMost = findDown(image, x);
        return (downMost - upMost + 1) * (rightMost - leftMost + 1);
    }
    
    private int findLeft(char[][] image, int end) {
        int start = 0;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isEmptyColumn(image, mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return isEmptyColumn(image, start) ? end : start;
    }
    
    private int findRight(char[][] image, int start) {
        int end = image[0].length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isEmptyColumn(image, mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return isEmptyColumn(image, end) ? start : end;
    }
    
    private int findUp(char[][] image, int end) {
        int start = 0;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isEmptyRow(image, mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return isEmptyRow(image, start) ? end : start;
    }
    
    private int findDown(char[][] image, int start) {
        int end = image.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isEmptyRow(image, mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return isEmptyRow(image, end) ? start : end;
    }
    
    private boolean isEmptyColumn(char[][] image, int index) {
        for (int i = 0; i < image.length; i++) {
            if (image[i][index] == '1') {
                return false;
            }
        }
        return true;
    }
    
    private boolean isEmptyRow(char[][] image, int index) {
        for (int j = 0; j < image[0].length; j++) {
            if (image[index][j] == '1') {
                return false;
            }
        }
        return true;
    }
}
