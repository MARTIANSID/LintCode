class Solution {
    
    HashMap<Integer,int[][]> dp;
    
    int MAX;
    
    public int waysToReachStair(int k) {
        
        dp = new HashMap<>();
        
        if(k == 0) {
            MAX = 3;
        } else {
            MAX = (int)Math.log(1e9) + 20;
        }
        
        return dfs(1,0,k,1);
     }
    
    public int dfs(int prevState, int jump, int k, int currStair) {
        
        int count = 0;
        
        if(currStair == k) {
            count++;
        }
        
        if((k == 0 && currStair > 1) || (k > 0 && currStair > 1e9)) {
            return 0;
        }
        
        if(dp.containsKey(currStair) && dp.get(currStair)[jump][prevState] != -1) {
            return dp.get(currStair)[jump][prevState];
            
        }
        

        
        if(currStair >= 1 && prevState == 1) {
            count += dfs(0,jump,k,currStair-1);
        }
        
        count += dfs(1,jump+1,k,currStair + (int)Math.pow(2,jump));
        
        
        if(!dp.containsKey(currStair)){
            dp.put(currStair, new int[MAX][2]);
            for(int[] r : dp.get(currStair)){
                Arrays.fill(r,-1);
            }
        }
        
        dp.get(currStair)[jump][prevState] = count;
        
        return count;
        
    }
}





