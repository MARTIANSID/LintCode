class Solution {
    public int countArrangement(int n) {
        
        
        int mask = 0;
    
        return dfs(n, mask, 1);
    }
    
    public int dfs(int n, int mask, int index) {
        
        
        
        if(index == n + 1) {
            return 1;
        }
        
        
        int count = 0;
        
        for(int i = 1; i <= n; i++){
            int x = (1<<i);
            
            int bit = (mask&x);
                        
            if(bit == 0) {
                if(i % index == 0 || index % i == 0) {
                    count += dfs(n,(mask|x),index+1);
                }
            }
        }
        return count;
    }
}


    