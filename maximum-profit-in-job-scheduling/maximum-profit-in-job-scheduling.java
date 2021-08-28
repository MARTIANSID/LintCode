class Solution {
    
    class job{
        int start;
        int end;
        int profit;
        job(int start,int end,int profit){
            this.start=start;
            this.end=end;
            this.profit=profit;
        }
    }
    
    class pair{ 
        int end;
        int profit;
        
        pair(int end,int profit){
            this.end=end;
            this.profit=profit;
        }
        
    }
    
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<job> jobs=new ArrayList<>();
        int n=profit.length;
        
        for(int i=0;i<n;i++){
            jobs.add(new job(startTime[i],endTime[i],profit[i]));
        }
        
        Collections.sort(jobs,(a,b)->{
           return a.start-b.start; 
        });
        
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->{
           return a.end-b.end; 
        });
        int max=0;
        for(int i=0;i<n;i++){
            
            while(pq.size()>0&&pq.peek().end<=jobs.get(i).start){
                
                max=Math.max(max,pq.peek().profit);
                pq.poll();
            }
            
            pq.add(new pair(jobs.get(i).end,jobs.get(i).profit+max));
            
        }
        max=0;
        while(pq.size()!=0){
            max=Math.max(max,pq.poll().profit);
        }
        
        return max;
        
    }
}