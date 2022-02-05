class Solution {
    
    class pair{
        int l;
        int r;
        
        pair(int l,int r){
            this.l=l;
            this.r=r;
        }
    }
    
    
    class query{
        int query;
        int index;
        query(int query,int index){
            this.query=query;
            this.index=index;
        }
    }
    
    public int[] minInterval(int[][] intervals, int[] queries) {
        
        
        int n =intervals.length;
        
        Arrays.sort(intervals,(a,b)->{
            return a[0]-b[0];
        });
        
        
        List<query> q=new ArrayList<>();
        
        for(int i=0;i<queries.length;i++){
            q.add(new query(queries[i],i));
        }
        
        
        Collections.sort(q,(a,b)->{
            return a.query-b.query;
        });
        
        int[] ans=new int[queries.length];
        
        
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->{
            int size1=a.r-a.l;
            int size2=b.r-b.l;
            
            return size1-size2;
        });
        
        int index=0;
        
        for(int i=0;i<q.size();i++){
            
            while(index<n&&intervals[index][1]<q.get(i).query){
                index++;
            }
            
            while(index<n&&intervals[index][0]<=q.get(i).query){
                pq.add(new pair(intervals[index][0],intervals[index][1]));
                index++;
            }
            
            while(pq.size()>0&&pq.peek().r<q.get(i).query){
                pq.poll();
            }
            
            if(pq.size()>0){
                ans[q.get(i).index]=(pq.peek().r-pq.peek().l)+1;
            }else{
                ans[q.get(i).index]=-1;
            }
            
        }
        
        return ans;
        
    }
}