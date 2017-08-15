/*
 * [380] Insert Delete GetRandom O(1)
 *
 * https://leetcode.com/problems/insert-delete-getrandom-o1
 *
 * Medium (39.13%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '["RandomizedSet","insert","remove","insert","getRandom","remove","insert","getRandom"]\n[[],[1],[2],[2],[],[1],[2],[]]'
 *
 * Can you solve this problem? 🤔
 */
public class RandomizedSet {
    private Random rand;
    private List<Integer> vals;
    private Map<Integer, Integer> map;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.rand = new Random();
        this.vals = new ArrayList<>();
        this.map = new HashMap<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        
        map.put(val, vals.size());
        vals.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        
        int index = map.get(val);
        int lastNum = vals.get(vals.size() - 1);
        vals.set(index, lastNum);
        map.put(lastNum, index);
        map.remove(val);
        vals.remove(vals.size() - 1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return vals.get(rand.nextInt(vals.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
