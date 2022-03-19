class FreqStack {
    HashMap<Integer,Stack<Integer>> map;
    HashMap<Integer,Integer> freq;
    int maxFreq=0;
    public FreqStack() {
        this.map=new HashMap<>();
        this.freq=new HashMap<>();
    }
    
    public void push(int val) {
        if(freq.containsKey(val)){
           int x= freq.get(val)+1;
            freq.put(val,x);
            if(x>maxFreq){
                maxFreq=x;
                Stack<Integer> st=new Stack<>();
                st.push(val);
                map.put(x,st);
            }else{
                map.get(x).push(val);
            }
        }else{
            freq.put(val,1);
            int x=1;
             if(x>maxFreq){
                maxFreq=x;
                Stack<Integer> st=new Stack<>();
                st.push(val);
                map.put(x,st);
            }else{
                map.get(x).push(val);
            }
            
        }
    }
    
    public int pop() {
       int val= map.get(maxFreq).pop();
        if(map.get(maxFreq).size()==0){
            map.remove(maxFreq);
            maxFreq--;
        }
        freq.put(val,freq.get(val)-1);
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */