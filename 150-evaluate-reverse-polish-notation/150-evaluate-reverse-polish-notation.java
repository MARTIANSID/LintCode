class Solution {
    public int evalRPN(String[] tokens) {
        int n=tokens.length;
        Stack<String> st =new Stack<>();
       
        for(String t:tokens){
            if(t.equals("+")){
               int ele1= Integer.parseInt(st.pop());
                int ele2=Integer.parseInt(st.pop());
                st.push((ele1+ele2)+"");
                
            }else if(t.equals("-")){
                int ele1= Integer.parseInt(st.pop());
                int ele2=Integer.parseInt(st.pop());
                st.push((ele2-ele1)+"");
            }else if(t.equals("/")){
                int ele1= Integer.parseInt(st.pop());
                int ele2=Integer.parseInt(st.pop());
                int x=ele2/ele1;
                st.push((x)+"");
            }else if(t.equals("*")){
                int ele1= Integer.parseInt(st.pop());
                int ele2=Integer.parseInt(st.pop());
                st.push((ele1*ele2)+"");
            }else{
                st.push(t);
            }
            
          
        }
        return Integer.parseInt(st.pop());
    }
}