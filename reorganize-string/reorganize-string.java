class Solution {
        
        class pair{
                char ch;
                int freq;
                
                pair(int freq,char ch){
                        this.ch=ch;
                        this.freq=freq;
                }
        }
    public String reorganizeString(String s) {
            
        HashMap<Character,Integer> map=new HashMap<>();
            
            for(int i=0;i<s.length();i++){
                    char ch=s.charAt(i);
                    if(map.containsKey(ch)){
                          int x=  map.get(ch);
                            map.put(ch,x+1);
                    }else{
                            map.put(ch,1);
                    }
            }
            
            PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->{
                    return b.freq-a.freq;
            });
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                pq.add(new pair(entry.getValue(),entry.getKey()));
}
                
            
            String ans="";
            while(pq.size()>1){
                  pair p1=  pq.poll();
                  pair p2=pq.poll();
                    
                    
                  if(ans.length()==0||ans.charAt(ans.length()-1)!=p1.ch){
                          if(p1.freq==1){
                                  ans+=p1.ch;
                                  pq.add(p2);
                          }else if(p1.freq>0){
                                  ans+=p1.ch;
                                     pair p=new pair(p1.freq-1,p1.ch);
                                  pq.add(p2);
                                  pq.add(p);
                          }
                       
                  }else{
                          
                           if(p2.freq==1){
                                  ans+=p2.ch;
                                  pq.add(p1);
                          }else if(p2.freq>0){
                                  ans+=p2.ch;
                                     pair p=new pair(p2.freq-1,p2.ch);
                                  pq.add(p1);
                                  pq.add(p);
                          }
                          
                          
                  }
                  
                    
            }
                      pair f=  pq.poll();
            if(f.freq==1){
                    ans+=f.ch;
                    return  ans;
            }else{
                    return "";
            }
            
            
            
            
    }
}