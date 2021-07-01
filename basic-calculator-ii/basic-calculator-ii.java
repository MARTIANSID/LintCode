class Solution {
        
        private void solve(Stack<Integer> st,char sign,int no){
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
        int si=0,ei=s.length();
            int no=0;
            char sign='~';
         for(int i=si;i<=ei;i++){
                
                 
                 char ch='~';
                 if(i!=ei)
                  ch=s.charAt(i);
                 
               
                 
                 if(Character.isDigit(ch)){
                         no=no*10+ch-'0';
                        
                        
                 }else if(ch!=' '&&i!=ei){
                         solve(st,sign,no);
                         sign=ch;
                         no=0;
                       
                 }
                 
                 if(i==ei){
                         solve(st,sign,no);
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