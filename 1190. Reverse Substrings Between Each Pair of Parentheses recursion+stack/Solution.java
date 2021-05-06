class Solution {
    public String reverseParentheses(String s) {
        
            return solve(s,0,s.length()-1);
    }
        public String solve(String s,int si,int ei){
                
                String ans="";
                
                for(int i=si;i<=ei;i++){
                        char ch=s.charAt(i);
                       if(ch=='('){
                               
                              Stack<Character> st=new Stack<>();
                               int x=i+1;
                               st.push('(');
                               while(st.size()!=0){
                                       if(s.charAt(x)==')'&&st.peek()=='('){
                                               st.pop();
                                               
                                               
                                       }else if(s.charAt(x)=='('){
                                               st.push('(');
                                       }
                                       x++;
                               }
                             
           String  str=     solve(s,i+1,x-2);
                               String reverse = new StringBuilder(str).reverse().toString();
                              
                               ans+=reverse;
                               i=x-1;
                             
                               
                       }else{
                              ans+=ch; 
                               
                       }
                        
                        
                }
                return ans;
        }
}