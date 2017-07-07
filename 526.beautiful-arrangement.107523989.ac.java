/*
 * [526] Beautiful Arrangement
 *
 * https://leetcode.com/problems/beautiful-arrangement
 *
 * Medium (55.14%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '2'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int countArrangement(int N) {
        int count = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }
        return search(list, 1);
    }
    
    private int search(List<Integer> list, int index) {
        if (list.size() == 1) {
            return list.get(0) % index == 0 || index % list.get(0) == 0 ? 1 : 0;
        }
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            int element = list.get(i);
            if (element % index == 0 || index % element == 0) {
                list.remove(Integer.valueOf(element));
                count += search(list, index + 1);
                list.add(i, element);
            }
        }
        return count;
    }
}
