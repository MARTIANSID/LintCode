class Solution {
    public int evalRPN(String[] tokens) {
        int n=tokens.length;
        Stack<Integer> st =new Stack<>();
       
        for(String t:tokens){
            if(t.equals("+")){
               int ele1= st.pop();
                int ele2=st.pop();
                st.push((ele1+ele2));
                
            }else if(t.equals("-")){
                int ele1= st.pop();
                int ele2=st.pop();
                st.push((ele2-ele1));
            }else if(t.equals("/")){
                int ele1= st.pop();
                int ele2=st.pop();
                int x=ele2/ele1;
                st.push((x));
            }else if(t.equals("*")){
                int ele1= st.pop();
                int ele2=st.pop();
                st.push((ele1*ele2));
            }else{
                st.push(Integer.parseInt(t));
            }
            
          
        }
        return st.pop();
    }
}