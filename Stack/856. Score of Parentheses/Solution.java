class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st=new Stack<>();
            
      
            int x=0;
            
            for(Character ch:s.toCharArray()){
                     if(ch=='('){
                             st.push(0);
                     }
                else{
                        x=0;
                        
                        while(st.peek()!=0){
                        
                              x+=  st.pop();
                                
                        }
                        st.pop();
                        if(x==0){
                     
                                   st.push(1);
                        }else{
                      
                                    st.push(2*x);
                        }
                        
                    
                }                  
            }
            int ans=0;
            while(st.size()!=0){
                    ans+=st.pop();
            }
            return ans;
    }
}