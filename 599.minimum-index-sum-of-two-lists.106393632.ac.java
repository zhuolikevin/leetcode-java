/*
 * [599] Minimum Index Sum of Two Lists
 *
 * https://leetcode.com/problems/minimum-index-sum-of-two-lists
 *
 * Easy (48.04%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '["Shogun","Tapioca Express","Burger King","KFC"]\n["Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        List<String> result = new ArrayList<>();
        int minSum = list1.length + list2.length - 2;
        for (int i = 0; i < list2.length; i++) {
            if (map.get(list2[i]) != null && map.get(list2[i]) + i <= minSum) {
                if (map.get(list2[i]) + i < minSum) {
                    result.clear();
                }
                result.add(list2[i]);
                minSum = map.get(list2[i]) + i;
            }
        }
        
        return result.toArray(new String[result.size()]);
    }
}
