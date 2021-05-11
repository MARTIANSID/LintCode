class Solution {
    class pair{
            char ch;
            int count;
            pair(char ch,int count){
                    this.ch=ch;
                    this.count=count;
            }
    }
    
public String removeDuplicates(String s, int k) {
    Stack<pair> st=new Stack<>();
        
     for(int i=0;i<s.length();i++){
             char ch=s.charAt(i);
             
             if(st.size()>0){
                     
                     if(st.peek().ch==ch){
                             if(st.peek().count+1==k){
                                     st.pop();
                             }else{
                                   pair p=  st.pop();
                                     p.count+=1;
                                     st.push(p);
                             }
                             
                     }else{
                             
                             st.push(new pair(ch,1));
                             
                     }
                     
                     
             }else{ 
                     st.push(new pair(ch,1));
             }
             
     }
    String ans="";            
        for(int i=0;i<st.size();i++){
                for(int j=0;j<st.get(i).count;j++){
                        ans+=st.get(i).ch;
                }
        }
        
        return ans;
   
}
}