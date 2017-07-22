/*
 * [604] Design Compressed String Iterator
 *
 * https://leetcode.com/problems/design-compressed-string-iterator
 *
 * Easy (31.69%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '["StringIterator","next","next","next","next","next","next","hasNext","next","hasNext"]\n[["L1e2t1C1o1d1e1"],[],[],[],[],[],[],[],[],[]]'
 *
 * Can you solve this problem? 🤔
 */
public class StringIterator {
    private Character curChar;
    private int count;
    private int index;
    private String str;
    
    public StringIterator(String compressedString) {
        this.curChar = null;
        this.count = 0;
        this.index = 0;
        this.str = compressedString;
    }
    
    public char next() {
        if (hasNext()) {
            if (count == 0) {
                curChar = str.charAt(index);
                index++;
                int sum = 0;
                while (index < str.length() && Character.isDigit(str.charAt(index))) {
                    sum = sum * 10 + str.charAt(index) - '0';
                    index++;
                }
                count = sum;
            }
            count--;
            return curChar;
        } else {
            return ' ';
        }
    }
    
    public boolean hasNext() {
        return index < str.length() || count > 0;
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
