class Solution {
    class monster{
        int distance;
        int speed;
        monster(int distance,int speed){
            this.distance=distance;
            this.speed=speed;
        }
    }
    public int eliminateMaximum(int[] dist, int[] speed) {
         int n=dist.length,minutesPassed=0;
        PriorityQueue<monster> pq=new PriorityQueue<>((a,b)->{
            double d1=(double)((double)a.distance/(double)a.speed);
            double d2=(double)((double)b.distance/(double)b.speed);
            
            return Double.compare(d1,d2);  
        });
        

        
        for(int i=0;i<n;i++){
            pq.add(new monster(dist[i],speed[i]));
        }
        
        int kills=0;
        int level=0;
        while(pq.size()>0){
         monster m=   pq.poll();
        int x=m.distance-(m.speed*minutesPassed);
        if(level!=0&&x<=0)return kills;
        minutesPassed++;
       level++;
            kills++;
            
        }
        
        return kills;
    }
}