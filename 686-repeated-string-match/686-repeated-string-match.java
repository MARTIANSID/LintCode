class Solution {
    
    static long power(long a, long n, long d) {
		a = a % d;
		long res = 1;
		while (n > 0) {
			if (n % 2 == 1) {
				res =((res%d)* (a%d))%d;
				n--;
			} else {
				a =((a%d)*(a%d))%d;
				n /= 2;
			}
		}
		return res%d;
	}
    
    
    int power=26;
    int mod=(int)1e9+7;
    public int repeatedStringMatch(String a, String b) {
            int k=b.length()-1;
        
         long[] powers=new long[k+1];
           for(int i=0;i<powers.length;i++){
            powers[i]=power(power,i,mod);
        }
        
      int hashValue=calculateHash(b,powers);
        
        boolean flag=false;
        
        int m=b.length()/a.length()+2;
        
        
        
        int si=0,ei=0,upper=m*a.length();
        
        long hash=0;
        int index=k;
        
        int u=a.length();
        
        
        
        while(ei<upper){
            
             int val=a.charAt(ei%u)-'a'+1;
            hash=(hash%mod+(val*powers[index--])%mod)%mod;
            ei++;
            
            if(ei-si==k+1){
                if(hash==hashValue){
                  return (int)Math.ceil((double)ei/(double)a.length());
                }
                
                int v=a.charAt(si%u)-'a'+1;
                hash=((hash)%mod-(v*powers[k])%mod+mod)%mod;
              
                hash=((hash)%mod*(power)%mod)%mod;
                si++;
                index=0;
            }
            
            
        }
        
        
        
        return -1;
    }
    
     public int calculateHash(String a,long[] powers){
        int k=a.length()-1,index=k;
        long ans=0;
        
        for(int i=0;i<a.length();i++){
            int val=a.charAt(i)-'a'+1;
             ans=(ans%mod+(val*powers[index--])%mod)%mod;
        }
        
        return (int)(ans%mod);
    } 
    
    
    
}