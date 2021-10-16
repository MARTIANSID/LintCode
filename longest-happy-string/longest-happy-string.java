class Solution{
    class pair{
        int count;
        char ch;
        pair(int count,char ch){
            this.count=count;
            this.ch=ch;
        }
    }
     // \U0001f622\U0001f622  
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb=new StringBuilder();
        PriorityQueue<pair> pq=new PriorityQueue<>((x,y)->{
            return y.count-x.count;
        });
        
        
        if(a!=0)
        pq.add(new pair(a,'a'));
        if(b!=0)
        pq.add(new pair(b,'b'));
        if(c!=0)
        pq.add(new pair(c,'c'));
        
        while(pq.size()>0){
           pair p1= pq.poll();
           
            char ch=p1.ch;
            int count=p1.count;
            if(p1.count>2){
             int x=2;
                while(x-->0){
                    sb.append(ch);
                }
                count-=2;
               
            }else{
                int x=1;
                while(x-->0){
                    sb.append(ch);
                }
                count-=1;
                if(pq.size()==0){
                    while(count-->0)sb.append(ch);
                }
            }
            int k=count;
            
            if(pq.size()==0)break;
            
            pair p2=pq.poll();
            if(count>0) pq.add(new pair(count,ch));
            count=p2.count;
            ch=p2.ch;
            
             if(count>2&&count>k){
                int x=2;
                while(x-->0){
                 sb.append(ch);
                }
                count-=2;
               
            }else{
                int x=1;
                while(x-->0){
                    sb.append(ch);
                }
                count-=1;
                
            }
            if(count>0) pq.add(new pair(count,ch));
            
        }
        
        String ans=new String(sb);
        return ans;
    }
}