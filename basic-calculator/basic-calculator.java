class Solution {
    public int calculate(String s) {
       
        return solve(s,0,s.length()-1);
    }
        
        public int solve(String s,int si,int ei){
                          

           Stack<Integer> st=new Stack<>();
            int no=0;
                char sign='0';
           for(int i=si;i<=ei;i++){
                 
        if(Character.isDigit(s.charAt(i))){
              
                      no = no*10+s.charAt(i)-'0';
                
                if(i==ei){
                        
                        
                        
                         if(sign=='+'){
                        
                        int n=no;
                        st.push(n);
                        sign=s.charAt(i);
                        no=0;
                        
                }else if(sign=='-'){
                       int n=no;
                        st.push(-n);
                        sign=s.charAt(i);
                                               no=0;

                        
                        
                }else if(sign=='*'){
                        
                        int n=no;
                        int y=st.pop();
                        
                        st.push(n*y);
                        
                        
                        sign=s.charAt(i);
                                             no=0;

                        
                        
                                
                }else if(sign=='/'){
                        
                        int n=no;
                        int y=st.pop();
                        
                        st.push(y/n);
                        
                        
                        sign=s.charAt(i);
                                                no=0;

                        
                }else {
                        sign=s.charAt(i);
                        int n=no;
                        st.push(n);
                                            no=0;

                } 
                        
                        
                }
              }
        else if(i==ei||s.charAt(i)=='-'||s.charAt(i)=='+'||s.charAt(i)=='*'||s.charAt(i)=='/'||s.charAt(i)=='?'){
                
                if(sign=='+'){
                        
                        int n=no;
                        st.push(n);
                        sign=s.charAt(i);
                        no=0;
                        
                }else if(sign=='-'){
                       int n=no;
                        st.push(-n);
                        sign=s.charAt(i);
                                               no=0;

                        
                        
                }else if(sign=='*'){
                        
                        int n=no;
                        int y=st.pop();
                        
                        st.push(n*y);
                        
                        
                        sign=s.charAt(i);
                                             no=0;

                        
                        
                                
                }else if(sign=='/'){
                        
                        int n=no;
                        int y=st.pop();
                        
                        st.push(y/n);
                        
                        
                        sign=s.charAt(i);
                                                no=0;

                        
                }else {
                        sign=s.charAt(i);
                        int n=no;
                        st.push(n);
                                            no=0;

                }
                
                
                
        }else if(s.charAt(i)=='('){
                
                Stack<Character> fuck=new Stack<>();
                
                fuck .push('(');
                
                i++;
                int u=i;
                while(fuck.size()!=0){
                        if(fuck.peek()=='('&&s.charAt(i)==')'){
                                fuck.pop();
                        }else if(s.charAt(i)=='('){
                                fuck.push('(');
                        }
                        i++;
                }
                
                
            no=solve(s,u,i-2);
                i--;
                
               if(i==ei){
                         if(sign=='+'){
                        
                        int n=no;
                        st.push(n);
                        sign=s.charAt(i);
                        no=0;
                        
                }else if(sign=='-'){
                       int n=no;
                        st.push(-n);
                        sign=s.charAt(i);
                                               no=0;

                        
                        
                }else if(sign=='*'){
                        
                        int n=no;
                        int y=st.pop();
                        
                        st.push(n*y);
                        
                        
                        sign=s.charAt(i);
                                             no=0;

                        
                        
                                
                }else if(sign=='/'){
                        
                        int n=no;
                        int y=st.pop();
                        
                        st.push(y/n);
                        
                        
                        sign=s.charAt(i);
                                                no=0;

                        
                }else {
                        sign=s.charAt(i);
                        int n=no;
                        st.push(n);
                                            no=0;

                }
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