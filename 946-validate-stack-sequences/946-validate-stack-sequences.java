class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st=new Stack<>();
        int n=pushed.length;
        int j=0,i=0;
        int top=-1;
        while(i<n){
             while(i<n && j<n && popped[j]!=top){
                 top=pushed[i];
                 st.push(pushed[i++]);
             }
            st.pop();
            if(st.size()>0)
            top=st.peek();
            j++;
        }
        
        
        while( j<n && st.size()>0 && st.peek()==popped[j]){
            st.pop();
            j++;
        }
        
             
        return st.size()==0?true:false;
        
    }
}