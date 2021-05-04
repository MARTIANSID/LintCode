class Solution {
    public String removeDuplicates(String s) {

            Stack<Character> st=new Stack<>();
            boolean pop=false;
            for(int i=0;i<s.length();i++){
                    char ch=s.charAt(i);
                    if(st.size()>0&&ch==st.peek()){
                            st.pop();
                            pop=true;
                    }
                    if(!pop)
                    st.push(ch);
                    pop=false;
            }
            String ans="";
            for(int i=0;i<st.size();i++){
                    ans+=st.get(i);
            }
            return ans;
    }
}