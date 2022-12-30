class MyCircularDeque {
    int size;
    int currentSize;
    int maxSize;

    class ListNode {
        ListNode next;
        ListNode prev;
        int val;

        ListNode(int val) {
            this.val = val;
        }
    }

    ListNode head;
    ListNode tail;

    public MyCircularDeque(int k) {
        this.size = k;
        this.currentSize = 0;
        this.maxSize = k;
    }

    public boolean insertFront(int value) {
        ListNode node = new ListNode(value);
        if (size == 0) return false;
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size--;
        currentSize++;
        return true;
    }

    public boolean insertLast(int value) {
        ListNode node = new ListNode(value);
        if (size == 0) return false;
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size--;
        currentSize++;
        return true;
    }

    public boolean deleteFront() {
        if (head == null) return false;
        size++;
        if (currentSize == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        currentSize--;
        return true;
    }

    public boolean deleteLast() {
        if (head == null) return false;
        size++;
        if (currentSize == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        currentSize--;
        return true;
    }

    public int getFront() {
        if (head == null) return -1;

        return head.val;
    }

    public int getRear() {
        if (head == null) return -1;

        return tail.val;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean isFull() {
        return maxSize == currentSize;
    }
}
/*
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
