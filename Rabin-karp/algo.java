class Solution
{
    
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
    static int power=26;
    
    static int mod=(int)1e9+7;
    
    ArrayList<Integer> search(String pat, String s)
    {
        // your code here
        
        ArrayList<Integer> ans=new ArrayList<>();
        
        int k=pat.length()-1,n=s.length();
        
          long[] powers=new long[k+1];
          
           for(int i=0;i<powers.length;i++){
            powers[i]=power(power,i,mod);
        }
        
    
        int hashValue=calculateHash(pat,powers);
        // System.out.println(hashValue);
        // System.out.println(calculateHash("nfo",powers));
        

        
        int ei=0,si=0,index=k;
        
        long hash=0;
        
        while(ei<n){
            int val=s.charAt(ei++)-'a'+1;
            hash=(hash%mod+(val*powers[index--])%mod)%mod;
            
            if(ei-si==k+1){
                if(hash==hashValue){
                    ans.add(si+1);
                }
                
                int v=s.charAt(si)-'a'+1;
                hash=((hash)%mod-(v*powers[k])%mod+mod)%mod;
              
                hash=((hash)%mod*(power)%mod)%mod;
                si++;
                index=0;
            }
                        
        }
        if(ans.size()==0)ans.add(-1);
        
        return ans;
        
        
        
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