class Solution {
            private void comp(Stack<Integer> st,char sign,int no){
                  if(sign=='+'){
                                 st.push(no);
                              
                                 
                         }else if(sign=='-'){
                                 st.push(-no);
                                 
                                 
                         }else if(sign=='*'){
                                 int number=st.pop();
                                 int result=number*no;
                                 st.push(result);
                             
                                 
                         }else if(sign=='/'){
                                  int number=st.pop();
                                 int result=number/no;
                                 st.push(result);
                                
                                 
                         }else{
                                
                                 st.push(no);
                               
                         }
                
        }

        
    public int calculate(String s) {
            
            
            
        Stack<Integer> st=new Stack<>();
            
            return solve(s,0,s.length());
            
    }
        public int solve(String s,int si,int ei){
                 Stack<Integer> st=new Stack<>();
                char sign='~';
                int no=0;
                  for(int i=si;i<=ei;i++){
                
                 
                 char ch='~';
                 if(i!=ei)
                  ch=s.charAt(i);
                 
               
                 
                 if(Character.isDigit(ch)){
                         no=no*10+ch-'0';
                        
                        
                 }else if(ch=='('){
                         
                        Stack<Character> util=new Stack<>();
                         util.push('(');
                         int y=i+1;
                         int x=i;
                         
                         while(util.size()!=0){
                                 if(util.peek()=='('&&s.charAt(y)==')'){
                                         util.pop();
                                 }else if(s.charAt(y)==')'||s.charAt(y)=='('){
                                         util.push(s.charAt(y));
                                 }
                                         
                                y++;         
                         }
                         
                         
                         
                         
                    int a=     solve(s,x+1,y-1);
                        
                        if(i==ei){
                         comp(st,sign,no);
                         sign=ch;
                         no=0;
                 }else{
                                no=a;
                        }
                         i=y-1;
                         
                         
                         
                         
                         
                 }
                          
                          else if(ch!=' '&&i!=ei){
                         comp(st,sign,no);
                         sign=ch;
                         no=0;
                       
                 }
                 
                 if(i==ei||s.charAt(i)==')'){
                         comp(st,sign,no);
                         sign=ch;
                         no=0;
                 }
                 
                 
                 
         }
                
                
               int ans=0;
           for(int i=0;i<st.size();i++){
                   ans+=st.get(i);
           }
            return ans;    
                
        }
}