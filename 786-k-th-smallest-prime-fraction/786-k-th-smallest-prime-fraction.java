class Solution {
    class pair{
        int num;
        int denom;
        pair(int num,int denom){
            this.num=num;
            this.denom=denom;
        }
    }
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n=arr.length;
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->{
            return Double.compare((double)((double)arr[a.num]/(double)arr[a.denom]),(double)((double)arr[b.num]/(double)arr[b.denom]));
        });
        
        for(int i=1;i<n;i++){
            pq.add(new pair(0,i));
        }
        
        while(k-->1){
           pair p= pq.poll();
           int num=p.num,denom=p.denom;
           if(num+1<n){
               pq.add(new pair(num+1,denom));
           }
        }
        return new int[]{arr[pq.peek().num],arr[pq.peek().denom]};
        
    }
}