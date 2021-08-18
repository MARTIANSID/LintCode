class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
    PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
        return a[2]-b[2];
    });
    int n=trips.length;
        
        Arrays.sort(trips,(a,b)->{
            return a[1]-b[1];
        });
        int seats=capacity;
        for(int i=0;i<n;i++){
           while(pq.size()>0&&pq.peek()[2]<=trips[i][1]){
               int[] peop=pq.poll();
                capacity+=peop[0];
           }
            
            pq.add(trips[i]);
            capacity-=trips[i][0];
            if(capacity<0)return false;
            
            
        }
        
        return true;
        
    }   
}


// 1,5    3,6.../
// 1,6
    
    