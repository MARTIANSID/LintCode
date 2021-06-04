class Solution {
    public int openLock(String[] deadends, String target) {
        LinkedList<String> que=new LinkedList<>();
            
               HashSet<String> dead = new HashSet<>(Arrays.asList(deadends));
          que.add("0000");
            
            if(dead.contains("0000")){
                    
                   return -1;
            }
            
            
            
        HashSet<String> visited = new HashSet<>();
            
            visited.add("0000");
            int level=0;
          while(que.size()!=0){
                  int size=que.size();
                  while(size-->0){
                          String s=que.removeFirst();
                          
                          if(s.equals(target)){
                                  return level;
                          }
                          
                          
                          for(int i=0;i<s.length();i++){
                                  
                          
                                             if(s.charAt(i)=='0'){
                                          
                                          StringBuilder myName = new StringBuilder(s);
          
                                        myName.setCharAt(i, '9');
                                          
                                       String first=new String(myName);
                                          
                                        
                                          
                                         if(!dead.contains(first)&&visited.add(first)){
                                                 
                                                 que.add(first);
                                               
                                         }
                                          
                                          
                                             StringBuilder m = new StringBuilder(s);
                                        m.setCharAt(i, '1'); 
                                          
                                          String second=new String(m);
                                          
                                         if(!dead.contains(second)&&visited.add(second)){
                                                 que.add(second);
                                                 
                                         }
                                          
                                  }else if(s.charAt(i)=='9'){
                                          
                                           StringBuilder myName = new StringBuilder(s);
                                        myName.setCharAt(i, '0');
                                          
                                       String first=new String(myName);
                                          
                                         if(!dead.contains(first)&&visited.add(first)){
                                                 que.add(first);
                                               
                                         }
                                          
                                          
                                             StringBuilder m = new StringBuilder(s);
                                        m.setCharAt(i, '8'); 
                                          
                                          String second=new String(m);
                                          
                                         if(!dead.contains(second)&&visited.add(second)){
                                                 que.add(second);
                                                
                                         }
                                          
                                          
                                          
                                  }else{
                                          
                                          
                                              StringBuilder myName = new StringBuilder(s);
                                                      
                                                char ch=s.charAt(i);
                                      int val=    Character.getNumericValue(ch);
                                          
                                        myName.setCharAt(i,  Character.forDigit(val+1,10));
                                          
                                       String first=new String(myName);
                                         
                                          
                                         if(!dead.contains(first)&&visited.add(first)){
                                                 que.add(first);
                                                
                                         }
                                          
                                          
                                             StringBuilder m = new StringBuilder(s);
                                        m.setCharAt(i,  Character.forDigit(val-1,10)); 
                                          
                                          String second=new String(m);
                                          
                                         if(!dead.contains(second)&&visited.add(second)){
                                                 que.add(second);
                                                
                                         }
                                          
                                  }
                                  
                                  
                               
                          }
                  }
                  level++;
          }  
            
            return -1;
    }
}