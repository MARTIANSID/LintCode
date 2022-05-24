class Solution {
    public int longestValidParentheses(String s) {
        int n=s.length();
        int max=0;
        Stack<Integer> st=new Stack<>();
        
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            
            if(st.size()>0){
                max=Math.max(max,i-st.peek()-1);
            }
            if(st.size()>0 && s.charAt(st.peek())=='(' && ch == ')'){
                st.pop();
                max=Math.max(max,i-(st.size()>0?st.peek():-1));
            }
            else{
                st.push(i);
            }
        }
        return max;
    }
}