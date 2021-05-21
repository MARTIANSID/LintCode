class Solution {
        class pair{
                int val;
                int freq;
                pair(int val,int freq){
                        this.val=val;
                        this.freq=freq;
                }
        }
    public int[] rearrangeBarcodes(int[] b) {
        HashMap<Integer,Integer> map=new HashMap<>();
            
            for(int i=0;i<b.length;i++){
                    if(map.containsKey(b[i])){
                           int x= map.get(b[i]);
                            map.put(b[i],x+1);
                    }else{
                            map.put(b[i],1);
                    }
            }
                    
                    
                    PriorityQueue<pair> pq=new PriorityQueue<>((a,d)->{
                         return   d.freq-a.freq;
                    });
                    
                    
                  for (Map.Entry mapElement : map.entrySet()) {
         
  
                        pq.add(new pair((int)mapElement.getKey(),(int)mapElement.getValue()));
        }
            
            int[] ans=new int[b.length];
            int c=0;
            while(pq.size()>1){
                 pair p=   pq.poll();
                    
                    if(c==0){
                            ans[c]=p.val;
                            int f=p.freq;
                            f=f-1;
                           if(f!=0){
                                   pq.add(new pair(p.val,f));
                           }
                    }else{
                            
                          if(ans[c-1]!=p.val){
                        ans[c]=p.val;
                            int f=p.freq;
                            f=f-1;
                           if(f!=0){
                                   pq.add(new pair(p.val,f));
                           }
                                  
                          } else{
                               pair o=   pq.poll();
                                  pq.add(p);
                                  
                        ans[c]=o.val;
                            int f=o.freq;
                            f=f-1;
                           if(f!=0){
                                   pq.add(new pair(o.val,f));
                           }
                                  
                          } 
                            
                    }
                    c++;
            }
            
            
            ans[b.length-1]=pq.poll().val;
            
            return ans;
            
            
                    
                    
            
    }
}