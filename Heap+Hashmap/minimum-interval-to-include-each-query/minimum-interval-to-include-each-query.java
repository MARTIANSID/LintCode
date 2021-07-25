class Solution {
    class pair{
        int query;
        int index;
        pair(int query,int index){
            this.query=query;
            this.index=index;
        }
    }
    
    class interval{
        int r;
        int l;
        interval(int r,int l){
            this.r=r;
            this.l=l;
        }
    }
    public int[] minInterval(int[][] intervals, int[] queries) {
        
        Arrays.sort(intervals,(a,b)->{
           return a[0]-b[0]; 
        });
        
        List<pair> pairOfqueries=new ArrayList<>();
        
        for(int i=0;i<queries.length;i++){
            pairOfqueries.add(new pair(queries[i],i));
        }
        
        Collections.sort(pairOfqueries,(a,b)->{
            return a.query-b.query;
        });
        
        PriorityQueue<interval> pq=new PriorityQueue<>((a,b)->{
           int r1=a.r,l1=a.l;
            int r2=b.r,l2=b.l;
            
          return (r1-l1+1) -(r2-l2+1);
            
        });
        int j=0;
        int[] ans=new int[queries.length];
        for(int i=0;i<pairOfqueries.size();i++){
            while(j<intervals.length&&pairOfqueries.get(i).query>=intervals[j][0]){
                pq.add(new interval(intervals[j][1],intervals[j][0]));
                j++;   
            }
            
            while(pq.size()>0&&pq.peek().r<pairOfqueries.get(i).query){
                pq.poll();
            }
            if(pq.size()>0)
            ans[pairOfqueries.get(i).index]=pq.peek().r-pq.peek().l+1;
            else
                 ans[pairOfqueries.get(i).index]=-1;
        
            
        }
        
        return ans;
        
        
    }
}