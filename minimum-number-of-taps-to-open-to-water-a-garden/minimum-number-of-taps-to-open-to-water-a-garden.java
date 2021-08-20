class Solution {
    public int minTaps(int n, int[] ranges) {
    
        List<int[]>  intervals=new ArrayList<>();
        
        for(int i=0;i<ranges.length;i++){
            intervals.add(new int[]{i-ranges[i],i+ranges[i]});
        }
        
        Collections.sort(intervals,(a,b)->{
            return a[0]-b[0];
        });
        
        int start=0;
        
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            return b[1]-a[1];
        });
        int count=0,i=0;
        while(start<n){
          
                while(i<ranges.length&&intervals.get(i)[0]<=start){
                    pq.add(intervals.get(i));
                    i++;
                }
            if(pq.size()<=0)return -1;
               start=pq.poll()[1];
                count++;
            
        }
        
        return count;
    }
}