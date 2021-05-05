class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Character> st=new Stack<>();
        Stack<Character> temp=new Stack<>();
            
            
           HashMap<Character,Integer> map=new HashMap<>(); 
            
            
         for(int i=0;i<s.length();i++){
                 char ch=s.charAt(i);
                  int c= map.getOrDefault(ch, 0);
                                map.put(ch,c+1);
                 if(st.size()>0){
                         
                        
                         if(st.peek()==ch&&map.get(ch)>=k){
                                 
                                 
                                 while(st.size()>0&&st.peek()==ch){
                                         temp.push(st.pop());
                                 }
                                 
                                 
                                 if(temp.size()!=k-1){
                                        
                                         while(temp.size()!=0){
                                                 st.push(temp.pop());
                                                 
                                                 
                                         }
                                         st.push(ch);
                                 }else{
                                         int x=0;
                                        
                                          while(temp.size()!=0){
                                                 x++;
                                                temp.pop();
                                                 
                                         }
                                      int y=   map.get(ch);
                                           map.put(ch,y-x-1);
                                 }
                                 
                         }else{
                                  
                        
                                 st.push(ch);
                         }
                         
                 }else{
                         

                        
                         st.push(ch);
                         
                 }
                 
         }
            String ans="";
            for(int i=0;i<st.size();i++){
                    ans+=st.get(i);
            }
            return ans;
    }
}