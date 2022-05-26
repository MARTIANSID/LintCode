class Solution {
    HashMap<Long,Integer> map=new HashMap<>();
    public int integerReplacement(int n) {
        return solve((long)n);
    }
    
    public int solve(long n){
        
        if(n == 1)return 0;
        
        
        if(map.containsKey(n))return map.get(n);
        
        int val =  (n&1) !=0 ? Math.min(solve(n+1),solve(n-1)) : solve(n/2);
        
        map.put(n,val+1);
        
        return val+1;
    }
}