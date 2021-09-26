class Solution {
    class pair{
        int end;
        long profit;
        pair(int end,long profit){
            this.end=end;
            this.profit=profit;
        }
    }
    public long maxTaxiEarnings(int n, int[][] rides) {
     
        Arrays.sort(rides,(a,b)->{
            return a[0]-b[0];
        });
       
        long max=0;
        
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->{
            return a.end-b.end;
        });
        
        
        long ans=0;
        for(int i=0;i<rides.length;i++){
            while(pq.size()>0&&pq.peek().end<=rides[i][0]){
                max=Math.max(max,pq.poll().profit);
            }
             pq.add(new pair(rides[i][1],rides[i][1]-rides[i][0]+rides[i][2]+max));
            ans=Math.max(rides[i][1]-rides[i][0]+rides[i][2]+max,ans);
        }
        
        return ans;

        
    }
    
//     public long solve(int index,int[] dp,int[][] rides){
        
        
//         long max=0;
//         for(int  i=index+1;i<rides.length;i++){
//             if(rides[index][1]<=rides[i][0]){
//                 max=Math.max(max,solve(i,dp,rides)+rides[i][1]-rides[i][0]+rides[i][2]);
//             }
//         }
//         return max;
        
//     }
}