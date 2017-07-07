/*
 * [170] Two Sum III - Data structure design
 *
 * https://leetcode.com/problems/two-sum-iii-data-structure-design
 *
 * Easy (24.07%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '["TwoSum","add","add","add","find","find"]\n[[],[1],[3],[5],[4],[7]]'
 *
 * Can you solve this problem? 🤔
 */
public class TwoSum {
    private Map<Integer, Integer> map;
    
    /** Initialize your data structure here. */
    public TwoSum() {
        this.map = new HashMap<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (int num : map.keySet()) {
            Integer expected = map.get(value - num);
            if (expected != null) {
                if (value - num != num) {
                    return true;
                }
                if (expected > 1) {
                    return true;
                }
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
