class Solution {
    public int maxEvents(int[][] events) {
        int n=events.length;
        
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        
        Arrays.sort(events,(a,b)->{
            return a[0]-b[0];
        });
        
        int index=0,count=0;
        for(int day=1;day<=(int)1e5;day++){
            while(index<n && events[index][0]<=day){
                pq.add(events[index++][1]);
            }
            while(pq.size()>0 && pq.peek()<day)pq.poll();
            if(pq.size()>0){
                count++;
                pq.poll();
            }
        }
        return count;
    }
}