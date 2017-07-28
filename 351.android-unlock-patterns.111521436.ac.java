/*
 * [351] Android Unlock Patterns
 *
 * https://leetcode.com/problems/android-unlock-patterns
 *
 * Medium (43.59%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '1\n1'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    private int count;
    public int numberOfPatterns(int m, int n) {
        if (m < 0 || n > 9 || m > n) {
            return 0;
        }
        
        count = 0;
        
        for (int total = m; total <= n; total++) {
            Set<Integer> visited = new HashSet<>();
            search(total, 0, 0, visited);
        }
        
        return count;
    }
    
    private void search(int total, int visitedNum, int lastNum, Set<Integer> visited) {
        if (total == visitedNum) {
            count++;
            return;
        }
        
        for (int i = 1; i <= 9; i++) {
            if (visited.contains(i)) {
                continue;
            }
            
            if (lastNum == 0 || canMove(lastNum, i, visited)) {
                visited.add(i);
                search(total, visitedNum + 1, i, visited);
                visited.remove(i);
            }
        }
    }
    
    private boolean canMove(int last, int cur, Set<Integer> visited) {
        switch (last) {
            case 1:
                if (cur == 3 && !visited.contains(2) ||
                    cur == 9 && !visited.contains(5) ||
                    cur == 7 && !visited.contains(4)) {
                    return false;
                }
                break;
            case 2:
                if (cur == 8 && !visited.contains(5)) {
                    return false;
                }
                break;
            case 3:
                if (cur == 1 && !visited.contains(2) ||
                    cur == 7 && !visited.contains(5) ||
                    cur == 9 && !visited.contains(6)) {
                    return false;
                }
                break;
            case 4:
                if (cur == 6 && !visited.contains(5)) {
                    return false;
                }
                break;
            case 6:
                if (cur == 4 && !visited.contains(5)) {
                    return false;
                }
                break;
            case 7:
                if (cur == 1 && !visited.contains(4) ||
                    cur == 3 && !visited.contains(5) ||
                    cur == 9 && !visited.contains(8)) {
                    return false;
                }
                break;
            case 8:
                if (cur == 2 && !visited.contains(5)) {
                    return false;
                }
                break;
            case 9:
                if (cur == 1 && !visited.contains(5) ||
                    cur == 3 && !visited.contains(6) ||
                    cur == 7 && !visited.contains(8)) {
                    return false;
                }
                break;
            default:
                return true;
        }
        return true;
    }
}
