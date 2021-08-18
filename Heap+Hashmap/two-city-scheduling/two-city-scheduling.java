class Solution {
    public int twoCitySchedCost(int[][] costs) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            int a1=a[0],b1=a[1];
            int a2=b[0],b2=b[1];
            int x=a1-b1;
            int y=a2-b2;
            return x-y;
        });
        
        for(int i=0;i<costs.length ;i++){
            pq.add(costs[i]);
        }
        
        int n=costs.length;
        int ans=0;
        for(int i=0;i<n;i++){
            if(i<n/2){
                ans+=pq.poll()[0];
            }else{
                ans+=pq.poll()[1];
            }
        }
        return ans;
        
        
    }          
}


