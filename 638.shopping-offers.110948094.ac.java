/*
 * [638] Shopping Offers
 *
 * https://leetcode.com/problems/shopping-offers
 *
 * Medium (40.51%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[2,5]\n[[3,0,5],[1,2,10]]\n[3,2]'
 *
 * Can you solve this problem? 🤔
 */
public class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int minCost = 0;
        for (int i = 0; i < needs.size(); i++) {
            minCost += needs.get(i) * price.get(i);
        }
        if (minCost == 0) {
            return 0;
        }
        
        for (List<Integer> sp : special) {
            List<Integer> newNeeds = new ArrayList<>();
            for (int i = 0; i < needs.size(); i++) {
                if (sp.get(i) > needs.get(i)) {
                    break;
                }
                
                newNeeds.add(needs.get(i) - sp.get(i));
            }
            if (newNeeds.size() == needs.size()) {
                minCost = Math.min(minCost, shoppingOffers(price, special, newNeeds) + sp.get(sp.size() - 1));
            }
        }
        
        return minCost;
    }
}
