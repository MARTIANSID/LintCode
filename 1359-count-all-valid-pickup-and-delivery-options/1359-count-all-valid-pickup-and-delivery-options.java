class Solution {
    
    int mod=(int)1e9+7;
    
    public int countOrders(int n) {
        
        long prev=1;
        
        for(int i=2;i<=n;i++){
            long terms=(i-1)*2+1;
            long sum=(((terms)*(terms+1))%mod)/2;
            prev=(prev*sum)%mod;
            
        }
        
        return (int)(prev%mod);
        
        
    }
}