import java.util.*;

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> itr;
    int next=-1;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.itr = iterator;
        if (iterator.hasNext()) {
            next = itr.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
       return next;
       
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        int val = next;
        if(itr.hasNext())
        next = itr.next();
        else next=-1;
        return val;
    }

    @Override
    public boolean hasNext() {
        return next == -1 ? false : true;
    }
}
