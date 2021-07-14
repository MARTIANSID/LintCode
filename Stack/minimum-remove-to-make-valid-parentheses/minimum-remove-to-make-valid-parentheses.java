class Solution {
        class pair{
                char ch='d';
                int index=0;
                pair(char ch,int index){
                    this.ch=ch;
                this.index=index;
                }
        }
        
    public String minRemoveToMakeValid(String s) {
        Stack<pair> st=new Stack<>();
            
            StringBuilder ss=new StringBuilder(s);
            
          for(int i=0;i<s.length();i++){
                  
                  if(st.size()>0){
                          if(st.peek().ch=='('&&s.charAt(i)==')'){
                                 st.pop();
                          } else if(s.charAt(i)==')'|| s.charAt(i)=='('){
                                  st.push(new pair(s.charAt(i),i));
                          }
                          
                  } else{
                         if(s.charAt(i)==')'|| s.charAt(i)=='('){
                                  st.push(new pair(s.charAt(i),i));
                          } 
                  }
          }
           
           while(st.size()!=0){
                   pair p=st.pop();
                   ss.deleteCharAt(p.index);
           }
            String ans=new String(ss);
            return  ans;
            
            
            
    }
        
        
}