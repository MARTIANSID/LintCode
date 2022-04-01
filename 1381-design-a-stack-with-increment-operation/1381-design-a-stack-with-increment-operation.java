class CustomStack {
    
    Stack<Integer> st;
    
    int maxSize=0;
        
    public CustomStack(int maxSize) {
        this.st=new Stack<>();
        this.maxSize=maxSize;
    }
    
    public void push(int x) {
        if(st.size()==maxSize)return;
        
        st.add(x);
    }
    
    public int pop() {
        if(st.size()>0)
        return st.pop();
        else
        return -1;
    }
    
    public void increment(int k, int val) {
        for(int i=0;i<Math.min(k,st.size());i++){
            st.set(i,st.get(i)+val);
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */