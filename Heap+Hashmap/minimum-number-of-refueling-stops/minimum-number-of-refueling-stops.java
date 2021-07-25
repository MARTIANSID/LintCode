class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            return b[1]-a[1];
        });
        
        
      int fuel=startFuel;
        int distance=0;
        int i=0,refill=0;
        while(distance+fuel<target){
            while(i<stations.length&&fuel+distance>=stations[i][0]){
                int[] c=new  int[2];
                c[0]=stations[i][0];
                c[1]=stations[i][1];
                pq.add(c);
                i++;
            }
            
            if(pq.size()==0)return -1;
           int[]  p= pq.poll();
            int fuelUsed=p[0]-distance;
            fuel=p[1]+fuel-fuelUsed;
            distance=p[0];
            refill++; 
        }
        return refill;
    }
}