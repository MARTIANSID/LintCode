class BrowserHistory {
    Stack<String> back;
    Stack<String> forward;
   
    public BrowserHistory(String homepage) {
        this.back =new Stack<>();
        this.forward =new Stack<>();
        this.back.add(homepage);
    }
    
    
    
    public void visit(String url) {
        forward.clear();
        this.back.add(url);
        
    }
    
    public String back(int steps) {
        steps++;
        if(steps>back.size()){
            while(back.size()>1){
                forward.add(back.pop());
            }
        }else{
            while(steps-->1){
                forward.add(back.pop());
            }
        }
        return back.peek();
    }
    
    public String forward(int steps) {
        if(steps>forward.size()){
            while(forward.size()>0){
                back.add(forward.pop());
            }
        }else{
            while(steps-->0){
                back.add(forward.pop());
            }
        }
        return back.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */