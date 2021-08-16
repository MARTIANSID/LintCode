
class Solution {

    public static long maximizeSum(long a[], int n, int k)
    {
        PriorityQueue<Long> pq=new PriorityQueue<>();
        
        for(int i=0;i<n;i++){
            pq.add(a[i]);
        }
        
        while(k-->0){
        long val=pq.poll();
        pq.add(-val);
        }
        
        long ans=0;
        while(pq.size()!=0){
            ans+=pq.poll();
        }
        return ans;
    }
}