/*
 * [547] Friend Circles
 *
 * https://leetcode.com/problems/friend-circles
 *
 * Medium (49.32%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[[1,1,0],[1,1,0],[0,0,1]]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int findCircleNum(int[][] M) {
        int N = M.length;
        boolean[] visited = new boolean[N];
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (visited[i]) { continue; }
            count++;
            Stack<Integer> stack = new Stack<>();
            stack.push(i);
            while (!stack.isEmpty()) {
                int curPerson = stack.pop();
                visited[curPerson] = true;
                for (int j = 0; j < N; j++) {
                    if (curPerson == j) { continue; }
                    if (M[curPerson][j] == 1 && !visited[j]) {
                        stack.push(j);
                        visited[j] = true;
                    }
                }
            }
        }
        return count;
    }
}
