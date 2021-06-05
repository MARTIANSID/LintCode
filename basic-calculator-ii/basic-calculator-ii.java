class Solution {
    public int calculate(String s) {
        
             s = s.replaceAll("\\s", ""); 
           Stack<Integer> st=new Stack<>();
            String no="";
                char sign='0';
           for(int i=0;i<s.length();i++){
                 
        if(Character.isDigit(s.charAt(i))){
              if(i<s.length()-1){
                      no+=s.charAt(i);
              }else{ 
                     
                      no+=s.charAt(i);
                       // System.out.println(no);
                          if(sign=='+'){
                        
                        int n=Integer.parseInt(no);
                        st.push(n);
                        sign=s.charAt(i);
                        no="";
                        
                }else if(sign=='-'){
                        int n=Integer.parseInt(no);
                        st.push(-n);
                        sign=s.charAt(i);
                        no="";
                        
                        
                }else if(sign=='*'){
                        
                         int n=Integer.parseInt(no);
                        int y=st.pop();
                        
                        st.push(n*y);
                        
                        
                        sign=s.charAt(i);
                        no="";
                        
                        
                                
                }else if(sign=='/'){
                        
                         int n=Integer.parseInt(no);
                        int y=st.pop();
                        
                        st.push(y/n);
                        
                                  // System.out.println(y);
                        
                        sign=s.charAt(i);
                        no="";
                        
                }else{
                      sign=s.charAt(i);
                           int n=Integer.parseInt(no);
                        st.push(n);
                        no="";
                }  
                      
              }
        }else if(s.charAt(i)!=' '){
                
                if(sign=='+'){
                        
                        int n=Integer.parseInt(no);
                        st.push(n);
                        sign=s.charAt(i);
                        no="";
                        
                }else if(sign=='-'){
                        int n=Integer.parseInt(no);
                        st.push(-n);
                        sign=s.charAt(i);
                        no="";
                        
                        
                }else if(sign=='*'){
                        
                         int n=Integer.parseInt(no);
                        int y=st.pop();
                        
                        st.push(n*y);
                        
                        
                        sign=s.charAt(i);
                        no="";
                        
                        
                                
                }else if(sign=='/'){
                        
                         int n=Integer.parseInt(no);
                        int y=st.pop();
                        
                        st.push(y/n);
                        
                        
                        sign=s.charAt(i);
                        no="";
                        
                }else{
                        sign=s.charAt(i);
                           int n=Integer.parseInt(no);
                        st.push(n);
                        no="";
                }
                
                
                
        }
            
    }
            int ans=0;
            while(st.size()!=0){
                    int x=st.pop();
                    // System.out.println(x);
                    ans+=x;
            }
            return ans;
}
}