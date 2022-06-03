class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        
        int n=profits.length;
        
        PriorityQueue<Integer> minPq=new PriorityQueue<>((a,b)->{
            return capital[a]-capital[b];
        });
        PriorityQueue<Integer> maxPq=new PriorityQueue<>((a,b)->{
            return b-a;
        });
        
        for(int i=0;i<n;i++)minPq.add(i);
        
        int index=0;
        while(k-->0){
            while(minPq.size()>0 && capital[minPq.peek()]<=w){
                maxPq.add(profits[minPq.poll()]);
            }
           
            if(maxPq.size() == 0)return w;
            w+=maxPq.poll();
        }
        return w;
        
    }
} 
