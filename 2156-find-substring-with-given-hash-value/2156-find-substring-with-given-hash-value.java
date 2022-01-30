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
    
    public String subStrHash(String s, int power, int mod, int k, int hashValue) {
        int n=s.length();
       
        StringBuilder sb=new StringBuilder();
    
        long ans=0;
        
        long[] powers=new long[k+1];
        
        for(int i=0;i<powers.length;i++){
            powers[i]=power(power,i,mod);
        }
        String a="";
        int ei=n-1,si=n-1;
        int index=k-1;
        while(ei>-1){
              int val=s.charAt(ei)-'a'+1;
           ans=(ans%mod+(val*powers[index--])%mod)%mod;
            sb.append(s.charAt(ei--));

            if(si-ei==k){
                String str=new String(sb);
               

                
                if(ans==hashValue){
                    a=str;
                }
                
                int c=s.charAt(si)-'a'+1;
                ans=(ans%mod-(c*powers[k-1])%mod+mod)%mod;
                ans=((ans%mod)*(power%mod))%mod;
                si--;
                index=0;
                sb.deleteCharAt(0);
            }
            
            
        }
        String reverse = new StringBuffer(a).reverse().toString();
        
       return reverse;
        
        
        
       
    }
    
}