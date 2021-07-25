class Solution {
    class pair{
        int apples;
        int rottDay;
        
        pair(int apples,int rottDay){
            this.apples=apples;
            this.rottDay=rottDay;
        }
    }
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->{
            return a.rottDay-b.rottDay;
        });
        int day=0,j=0;
        for(int i=0;i<apples.length;i++){
            pq.add(new pair(apples[i],i+days[i]));
          
            while(pq.size()!=0&& pq.peek().rottDay<=i){
                pq.poll();
            }
            
            if(pq.size()!=0){
              pair apple=  pq.poll();
                pair ne=new pair(apple.apples-1,apple.rottDay);
                if(ne.apples>0){
                    pq.add(ne);
                }
                day++;
            }
            j=i;
        }
      
      j=j+1;
        // System.out.println(j);
        while(pq.size()!=0){
            
        
             while(pq.size()!=0&& pq.peek().rottDay<=j){
                pq.poll();
            }
            
            if(pq.size()!=0){
              pair apple=  pq.poll();
                pair ne=new pair(apple.apples-1,apple.rottDay);
                if(ne.apples>0){
                    pq.add(ne);
                }
                day++;
            }
            j++;
           
        }
        
        return day;
    }
}