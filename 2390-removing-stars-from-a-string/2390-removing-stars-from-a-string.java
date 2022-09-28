class Solution {
    public String removeStars(String s) {
        int n=s.length();
        
        Stack<Character> st=new Stack<>();
        
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(st.size()>0 && ch=='*'){
                st.pop();
            }else{
                st.push(ch);
            }
        }
        StringBuilder sb=new StringBuilder();
        
        for(int i=0;i<st.size();i++){
            sb.append(st.get(i));
        }
        return new String(sb);
        
    }
}