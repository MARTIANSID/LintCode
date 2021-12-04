class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events,(a,b)->{
            return a[0]-b[0];
        });
        
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            return a[1]-b[1];
        });
        
    
        int max=0,om=0;
        for(int[] e:events){
            while(pq.size()>0&&pq.peek()[1]<e[0]){
                max=Math.max(max,pq.peek()[2]);
                pq.poll();
            }
            
            pq.add(new int[]{e[0],e[1],e[2]});
            om=Math.max(om,e[2]+max);
            
            
        }
        
        return om;
        
        
        
    }
}