/*
 * [464] Can I Win
 *
 * https://leetcode.com/problems/can-i-win
 *
 * Medium (24.74%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '10\n11'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        List<Integer> candidates = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < maxChoosableInteger; i++) {
            sum += maxChoosableInteger - i;
            candidates.add(maxChoosableInteger - i);
        }
        
        if (sum < desiredTotal) {
            return false;
        }
        
        Map<Integer, Map<String, Boolean>> cache = new HashMap<>();
        return helper(candidates, desiredTotal, cache);
    }
    
    private boolean helper(List<Integer> candidates, int target, Map<Integer, Map<String, Boolean>> cache) {
        String candStr = getCandStr(candidates);
        if (!cache.containsKey(target)) {
            cache.put(target, new HashMap<>());
        }
        Map<String, Boolean> map = cache.get(target);
        if (map.containsKey(candStr)) {
            return map.get(candStr);
        }
        
        for (int i = 0; i < candidates.size(); i++) {
            int number = candidates.get(i);
            if (number >= target) {
                map.put(candStr, true);
                return true;
            }
            candidates.remove(Integer.valueOf(number));
            boolean canWin = !helper(candidates, target - number, cache);
            candidates.add(i, number);
            if (canWin) {
                map.put(candStr, true);
                return true;
            }
        }
        map.put(candStr, false);
        return false;
    }
    
    private String getCandStr(List<Integer> candidates) {
        StringBuilder sb = new StringBuilder();
        for (int cand : candidates) {
            sb.append(cand);
        }
        return sb.toString();
    }
}
