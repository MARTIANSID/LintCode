class Solution {
    public String decodeString(String s) {
        return solve(s,0,s.length()-1);
    }
        
        public String solve(String s,int si,int ei){
             
                String ans="";
                String no="";
                for(int i=si;i<=ei;i++){
                
                        if(Character.isDigit(s.charAt(i))){
                                no+=s.charAt(i);
                        } else if(s.charAt(i)=='['){
                                int n=Integer.parseInt(no);
                                no="";
                                int x=i+1;
                                 Stack<Character> st=new Stack<>();
                                st.push('[');
                                int y=x;
                                while(st.size()!=0){
                                     if(s.charAt(y)==']'&&st.peek()=='['){
                                             st.pop();
                                             y++;
                                     } else  if(s.charAt(y)=='[') {
                                             st.push('[');
                                             y++;
                                     }else{
                                             y++;
                                     }
                                       
                                }
                                i=y-1;
                               String a= solve(s,x,i-1);
                                for(int j=0;j<n;j++){
                                        ans+=a;
                                }
                                
                                
                        }else{
                                ans+=s.charAt(i);
                        }
                        
                }
                return ans;
        }
}