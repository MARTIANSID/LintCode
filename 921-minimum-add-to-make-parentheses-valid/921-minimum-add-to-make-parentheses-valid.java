class Solution {
    public int minAddToMakeValid(String s) {
        int n=s.length();    
        
        int open=0,unbalanced=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='('){
                open++;
            }else{
               if(open==0){
                   unbalanced++;
               }else{
                   open--;
               }
            }
        }
        return unbalanced+open;
    
    }
}