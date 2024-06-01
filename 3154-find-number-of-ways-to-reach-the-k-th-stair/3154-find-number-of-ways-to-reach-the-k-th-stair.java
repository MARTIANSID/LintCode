class Solution {
    
    HashMap<Integer,int[][]> dp;
    
    int MAX;
    
    int[] exp = new int[30];
    
    public int waysToReachStair(int k) {
        
        dp = new HashMap<>();
        
        if(k == 0) {
            MAX = 3;
        } else {
            MAX = (int)Math.log(1e9) + 20; // here 20 compensates for y roughly
        }
        
        
        
        for(int i = 0; i < 30; i++) {
            exp[i] = (1<<i);
        }
        
        return dfs(1,0,k,1);
     }
    
    public int dfs(int prevState, int jump, int k, int currStair) {
        
        if (currStair > k + 1) return 0;
        
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
        
        count += dfs(1,jump+1,k,currStair + exp[jump]);
        
        
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





