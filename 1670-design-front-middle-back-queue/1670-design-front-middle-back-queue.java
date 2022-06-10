class FrontMiddleBackQueue {
    LinkedList<Integer> left;
    LinkedList<Integer> right;

    public FrontMiddleBackQueue() {
        this.left = new LinkedList<>();
        this.right = new LinkedList<>();
    }

    public void pushFront(int val) {
        left.addFirst(val);
        if (left.size() > right.size() + 1) {
            right.addFirst(left.removeLast());
        }
    }

    public void pushMiddle(int val) {
       if(left.size()==right.size()){
           left.add(val);
       }else{
           int mid=left.removeLast();
           left.add(val);
           right.addFirst(mid);
       }
    }

    public void pushBack(int val) {
        right.add(val);
        if (right.size() > left.size()) {
            left.add(right.removeFirst());
        }
    }

    public int popFront() {
        if (left.size() == 0) return -1;

        int val = left.removeFirst();
        if (left.size() < right.size()) {
            left.add(right.removeFirst());
        }

        return val;
    }

    public int popMiddle() {
        if (right.size() == 0 && left.size() == 0) return -1;
        int val = left.removeLast();

        if (left.size() < right.size()) {
            left.add(right.removeFirst());
        }
        return val;
    }

    public int popBack() {
        if (right.size() == 0 && left.size() == 0) return -1;
        if (right.size() == 0) return left.removeLast();

        int val = right.removeLast();
        if (left.size() > right.size() + 1) {
            right.addFirst(left.removeLast());
        }
        return val;
    }
}
/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */
