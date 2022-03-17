class Solution {
    //opening -1
    
    public int scoreOfParentheses(String s) {
        int n=s.length();
        int totalScore=0,insideScore=0;
        Stack<Integer> st=new Stack<>();
        
        for(int i=0;i<n;i++){
            if(s.charAt(i)==')'){
                while(st.peek()!=-1){
                    insideScore+=st.pop();
                }
                st.pop();
              
                if(st.size()==0){
                    totalScore+=(insideScore==0?1:(2*insideScore));
                    // System.out.println(totalScore);
                
                    insideScore=0;
                }else{
                    insideScore=(insideScore==0?1:(2*insideScore));
                    st.push(insideScore);
                     insideScore=0;
                }
                  
            }else{
                st.push(-1);
            }
        }
       
        return totalScore;
    }
}