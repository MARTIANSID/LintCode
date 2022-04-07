class DinnerPlates {
    int capacity;
    List<Stack<Integer>> stacks;
    TreeSet<Integer> pushStack;
    TreeSet<Integer> popStack;

    public DinnerPlates(int capacity) {
        this.capacity = capacity;
        this.stacks = new ArrayList<>();
        this.pushStack = new TreeSet<>();
        this.popStack = new TreeSet<>();
    }

    public void push(int val) {
        int index = pushStack.size() == 0 ? -1 : pushStack.first();

        if (index != -1) {
            if (stacks.get(index).size() == 0) {
                popStack.add(index);
            }

            stacks.get(index).add(val);
            if (stacks.get(index).size() == capacity) {
                pushStack.remove(index);
            }
        } else {
            Stack<Integer> st = new Stack<>();
            st.push(val);
            stacks.add(st);
            if (1 < capacity) {
                pushStack.add(stacks.size() - 1);
                
            }
            popStack.add(stacks.size() - 1);
        }
    }

    public int pop() {
        if (stacks.size() == 0 || popStack.size() == 0) return -1;

        int index = popStack.last();

        int val = stacks.get(index).pop();

        pushStack.add(index);

        if (stacks.get(index).size() == 0) popStack.remove(index);

        return val;
    }

    public int popAtStack(int index) {
        if (index > stacks.size() - 1 || stacks.get(index).size() == 0) return -1;

        int val = stacks.get(index).pop();

        pushStack.add(index);

        if (stacks.get(index).size() == 0) popStack.remove(index);

        return val;
    }
}
/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates obj = new DinnerPlates(capacity);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAtStack(index);
 */
