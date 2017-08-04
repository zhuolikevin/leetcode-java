/*
 * [416] Partition Equal Subset Sum
 *
 * https://leetcode.com/problems/partition-equal-subset-sum
 *
 * Medium (39.06%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,5,11,5]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            sum += num;
            list.add(num);
        }
        
        if (sum % 2 == 1) {
            return false;
        }
        
        Collections.sort(list);
        Map<Integer, Map<String, Boolean>> cache = new HashMap<>();
        return helper(list, sum / 2, cache);
    }
    
    private boolean helper(List<Integer> nums, int target, Map<Integer, Map<String, Boolean>> cache) {
        String str = getStr(nums);
        if (!cache.containsKey(target)) {
            cache.put(target, new HashMap<>());
        }
        if (cache.get(target).containsKey(str)) {
            return cache.get(target).get(str);
        }
        
        Map<String, Boolean> map = new HashMap<>();
        
        if (target == 0) {
            map.put(str, true);
            cache.put(target, map);
            return true;
        }
        
        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);
            if (num > target) {
                break;
            }
            
            nums.remove(Integer.valueOf(num));
            boolean find = helper(nums, target - num, cache);
            nums.add(i, num);
            
            if (find) {
                map.put(str, true);
                cache.put(target, map);
                return true;
            }
        }
        
        map.put(str, false);
        cache.put(target, map);
        return false;
    }
    
    private String getStr(List<Integer> nums) {
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num);
        }
        return sb.toString();
    }
}
