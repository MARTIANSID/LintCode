class Solution {
    
    class Log{
        int id;
        int time;
        int executionTime;
        Log(int id,int time,int executionTime){
            this.id=id;
            this.time=time;
            this.executionTime=executionTime;
        }
    }
    
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans=new int[n];
        Stack<Log> st=new Stack<>();
        
        for(String log:logs){
            String[] logDetails=log.split(":");
            int id=Integer.parseInt(logDetails[0]),timestamp=Integer.parseInt(logDetails[2]);
            String state=logDetails[1];

            
            if(state.equals("end")){
                if(st.size()>0 && st.peek().id == id){
                   Log data= st.pop();
                   int time=(timestamp-data.time+1);
                   ans[id]+=time+data.executionTime;
                
                }
                if(st.size()>0){
                    st.peek().time=timestamp+1;
                }
                
            }else{
                if(st.size()>0){
                    st.peek().executionTime+=timestamp-st.peek().time;
                }
                st.push(new Log(id,timestamp,0));
                
            }
        }
        return ans;
    }
}