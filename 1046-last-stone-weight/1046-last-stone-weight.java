class Solution {
    public int lastStoneWeight(int[] stones) {
        int n=stones.length;
        
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
            return b-a;
        });
        
        for(int ele:stones){
            pq.add(ele);
        }
        while(pq.size()>1){
            int y=pq.poll();
            int x=pq.poll();
            if(x!=y){
                pq.add(y-x);
            }
        }
        
        if(pq.size()==0)return 0;
        
        return pq.poll();
        
    }
}