class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events,(a,b)->{
            return a[0]-b[0];
        });
        
        int n=events.length;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        
        int i=0,d=events[0][0];
        int ans=0;
     for(int j=0;j<100000;j++){
            
           while(i<n&&events[i][0]==d){
               pq.add(events[i][1]);
               i++;
           }
           
           // if(pq.size()==0)break;
           while(pq.size()>0&&pq.peek()<d){
               pq.poll();
               
           }
           if(pq.size()!=0){
                  pq.poll();
               ans++;
           }
        
        // if(pq.size()==0&&i==n)break;

           d++;
       }
        return ans;
    }
}