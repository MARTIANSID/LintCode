class Solution {
    
    public int smallestChair(int[][] times, int targetFriend) {
        
        int n=times.length;
        
        for(int i=0;i<n;i++){
            int[] a=times[i];
            times[i]=new int[]{a[0],a[1],i};
        }
        
        Arrays.sort(times,(a,b)->{
            return a[0]-b[0];
     });

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            return a[1]-b[1];
        });
        
        PriorityQueue<Integer> p=new PriorityQueue<>();
        
        
        for(int i=0;i<n;i++){
            p.add(i);
        }
        
        
        for(int i=0;i<n;i++){
            while(pq.size()>0&&pq.peek()[1]<=times[i][0]){
                p.add(pq.poll()[2]);
            }
            
            if(targetFriend==times[i][2])return p.peek();
            
           
            pq.add(new int[]{times[i][0],times[i][1], p.poll()});
            
        }
        
        return -1;
    }
}