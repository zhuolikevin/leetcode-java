/*
 * [359] Logger Rate Limiter
 *
 * https://leetcode.com/problems/logger-rate-limiter
 *
 * Easy (59.47%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '["Logger","shouldPrintMessage","shouldPrintMessage","shouldPrintMessage","shouldPrintMessage","shouldPrintMessage","shouldPrintMessage"]\n[[],[1,"foo"],[2,"bar"],[3,"foo"],[8,"bar"],[10,"foo"],[11,"foo"]]'
 *
 * Can you solve this problem? 🤔
 */
public class Logger {
    Map<String, Integer> map;

    /** Initialize your data structure here. */
    public Logger() {
        this.map = new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!map.containsKey(message) || timestamp - map.get(message) >= 10) {
            map.put(message, timestamp);
            return true;
        } else {
            return false;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
