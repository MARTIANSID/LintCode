class Solution {
    public int maximumScore(int a, int b, int c) {
        
            PriorityQueue<Integer> pq=new PriorityQueue<>((j,k)->{
                    return k-j;
            });
            
            pq.add(a);
            pq.add(b);
            pq.add(c); 
            
            int ans=0;
            while(pq.size()>1){
                    int x=pq.poll();
                    int y=pq.poll();
                    x=x-1;
                    y=y-1;
                    ans+=1;
                    if(x!=0)
                    pq.add(x);
                    if(y!=0)
                    pq.add(y);
            }
            
            return ans;
            }
}