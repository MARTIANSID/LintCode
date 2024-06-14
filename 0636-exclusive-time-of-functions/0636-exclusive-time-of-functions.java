class Solution {
    
    class pair{
        int funcId;
        int start;
        
        pair(int funcId,int start) {
            this.funcId = funcId;
            this.start = start;
        }
    }
    
// ÷
    public int[] exclusiveTime(int n, List<String> logs) {
        
        int size = logs.size(), timestamp = 0;
        
        int[] ans = new int[n];
        
        Stack<pair> st = new Stack<>();
        
        for(int i = 0; i < size; i++) {
            String[] log = logs.get(i).split(":");
            int funcId = Integer.parseInt(log[0]), time = Integer.parseInt(log[2]);
            String startOrEnd = log[1];
            
            
            
            if(st.size() == 0) { // it will be start of a function
                st.add(new pair(funcId,time));    
                timestamp = time;
            } else {
                int topElementFuncId = st.peek().funcId;
                int topElementStart = st.peek().start;
                
                if(topElementFuncId == funcId && startOrEnd.equals("end")) {
                    st.pop();
                    ans[funcId] += (time - timestamp + 1);
                    timestamp = time + 1;
                } else {
                    ans[topElementFuncId] += (time - timestamp);
                    timestamp = time;
                    st.push(new pair(funcId,time));
                }
                
            }
            
        }
        return ans;
        
    }
}


// timestamp = 7

// ["0:start:0","0:end:7"]


// {
//     0 :  2 + 4 + 0 + 1
//     1 : 1
// }