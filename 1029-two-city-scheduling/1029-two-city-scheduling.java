class Solution {
    /*
    Greedy Logic - > we want to send a person either to city A or  city B question is how do we decide this
    
    */
    
    public int twoCitySchedCost(int[][] costs) {
        
        int n=costs.length;
        
        Arrays.sort(costs,(a,b)->{
            int diff1=a[0]-a[1];
            int diff2=b[0]-b[1];
            return diff1-diff2;
        });
            
        int i=0,j=n-1;
        
        int cost=0;
        while(i<j){
            cost+=(costs[i++][0]);
            cost+=(costs[j--][1]);
        }
        return cost;
    }
    // 10-20=-10
    // 30-200=-170
    // 400-50=350
    // 30-20=10
}