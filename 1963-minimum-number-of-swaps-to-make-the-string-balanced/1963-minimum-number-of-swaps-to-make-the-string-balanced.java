class Solution {
    public int minSwaps(String text) {
     Stack<Integer> st=new Stack<>();
    
    int n=text.length();
    
    for(int i=0; i<n; i++){
        if(st.size()>0 && text.charAt(st.peek()) =='['&&text.charAt(i)==']'){
            st.pop();
        }else{
          st.push(i);
        }
    }
    
    
    int x=st.size();
    

        
        if(x==2)return 1;
        
        
    int div=x/4;
    int rem=x%4;
        
    return div+rem/2;
        
        
            
    }
}