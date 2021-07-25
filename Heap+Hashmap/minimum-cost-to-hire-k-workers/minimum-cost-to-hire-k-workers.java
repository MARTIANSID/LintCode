class Solution {
    class pair{
        double ratio;
        int quality;
        int wage;
        pair(double ratio,int quality,int wage){
            this.ratio=ratio;
            this.quality=quality;
            this.wage=wage;
        }
    }
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        
       List<pair> workers=new ArrayList<>();
        for(int i=0;i<quality.length;i++){
          workers.add(new pair((double)wage[i]/(double)quality[i],quality[i],wage[i]));
        }
        
        Collections.sort(workers,(a,b)->{
            return Double.compare(a.ratio,b.ratio);
        });
        
        int sumQuality=0;
        
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
            return b-a;
        });
        
        int  w=k;
        int j=0;
        double captinRatio=0;
        double min=(double)1e9;
        while(w-->0){
            sumQuality+=workers.get(j).quality;
            pq.add(workers.get(j).quality);
            captinRatio=workers.get(j).ratio;
            j++;
        }
        min=Math.min(min,sumQuality*captinRatio);
        for(int i=k;i<workers.size();i++){
             captinRatio=workers.get(i).ratio;
            int  captinQuality=workers.get(i).quality;
            if(pq.peek()<captinQuality){
                int y=sumQuality;
                y-=pq.peek();
                y+=captinQuality;
                min=Math.min(min,y*captinRatio);
            }else{
                sumQuality-=pq.poll();
                sumQuality+=captinQuality;
                pq.add(captinQuality);
                min=Math.min(min,sumQuality*captinRatio);
            }
            
        }
        return min;
      
    }
}
