/*
 * [284] Peeking Iterator
 *
 * https://leetcode.com/problems/peeking-iterator
 *
 * Medium (35.41%)
 * Total Accepted:    
 * Total Submissions: 
 * Testcase Example:  '[1,2,3,4]\n[0,1,1,2,2,1,1,2,0,1,0,2,0]'
 *
 * Can you solve this problem? 🤔
 */
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    private Integer peek;
    private Iterator<Integer> iterator;

	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        this.iterator = iterator;
        if (iterator.hasNext()) {
            peek = iterator.next();
        } else {
            peek = null;
        }
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return peek;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        if (hasNext()) {
            int temp = peek;
            if (iterator.hasNext()) {
                peek = iterator.next();
            } else {
                peek = null;
            }
            return temp;
        } else {
            return null;
        }
	}

	@Override
	public boolean hasNext() {
	    return peek != null;
	}
}
