/*
 * [349] Intersection of Two Arrays
 *
 * https://leetcode.com/problems/intersection-of-two-arrays
 *
 * Easy (47.03%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[]\n[]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return intersection(nums2, nums1);
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums2) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        for (int num : nums1) {
            if (map.get(num) != null && map.get(num) > 0) {
                res.add(num);
                map.put(num, 0);
            }
        }
        int[] resArr = new int[res.size()];
        for (int i = 0; i < resArr.length; i++) {
            resArr[i] = res.get(i);
        }
        return resArr;
    }
}
