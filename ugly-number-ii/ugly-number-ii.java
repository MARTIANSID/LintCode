class Solution {
    // int mod=(int)1e9+7;
    public int nthUglyNumber(int n) {
        if(n==1)return 1;
        PriorityQueue<Long> pq=new PriorityQueue<>();
        pq.add((long)1);
        n--;
        HashSet<Long> set=new HashSet<>();
        while(n-->0){
            long val=pq.poll();
            
            if(set.add(2*val))
            pq.add(2*val);
            if(set.add(3*val))

            pq.add(3*val);
             if(set.add(5*val))

            pq.add(5*val);

        }
        return (int) (long)pq.poll();
        
    }
}