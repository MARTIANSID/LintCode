class Solution {
    public int calPoints(String[] ops) {
        int n=ops.length;
        Stack<Integer> st=new Stack<>();
        
        for(String str:ops){
            if(str.equals("+")){
                int ele1=st.pop();
                int ele2=st.pop();
                st.push(ele2);
                st.push(ele1);
                st.push(ele1+ele2);
            }else if(str.equals("D")){
                st.push(2*st.peek());
            }else if(str.equals("C")){
                st.pop();
            }else{
                st.push(Integer.parseInt(str));
            }
        }
        int sum=0;
        for(int ele:st){
            sum+=ele;
        }
        return sum;
    }
}