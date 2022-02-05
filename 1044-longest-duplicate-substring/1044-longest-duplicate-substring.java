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
    static int power=26;
    
    static int mod=(int)1e9+7;
    
    public String longestDupSubstring(String s) {
        
        int n=s.length();
        
        int si=0,ei=s.length();
        
        
         long[] powers=new long[n];
          
           for(int i=0;i<powers.length;i++){
            powers[i]=power(power,i,mod);
        }
        
        while(si<=ei){
            int mid=(si+ei)/2;
            
            if(isPossible(s,mid,powers)){
                si=mid+1;
            }else{
                ei=mid-1;
            }
        }
    
        
        System.out.println(ei);
        
        return findString(s,ei,powers);
    }
    
    public boolean isPossible(String s,int length,long[] powers){
        
        
        
       HashMap<Long,List<Integer>> map=new HashMap<>();
        
        int n=s.length();
        
        int k=length-1;
       
        if(k==-1)return true;
        
        int ei=0,si=0,index=k;
        
        long hash=0;
        
        while(ei<n){
             int val=s.charAt(ei++)-'a'+1;
            hash=(hash%mod+(val*powers[index--])%mod)%mod;
            
            if(ei-si==length){
                
                if(map.containsKey(hash)){
                    String curr=s.substring(si,ei);
                   List<Integer> ind= map.get(hash);
                    for(int ele:ind){
                        
                        String ss=s.substring(ele,ele+length);
                        if(ss.equals(curr))return true;
                    }
                    
                }else{
                    List<Integer> temp=new ArrayList<>();
                        
                        temp.add(si);
                        map.put(hash,temp);
                }
                
                
                int v=s.charAt(si)-'a'+1;
                hash=((hash)%mod-(v*powers[k])%mod+mod)%mod;
              
                hash=((hash)%mod*(power)%mod)%mod;
                si++;
                index=0;
            }
        }
           
        
        return false;
        
        
    }
    
    
     public String findString(String s,int length,long[] powers){
        
         HashMap<Long,List<Integer>> map=new HashMap<>();
        
        int n=s.length();
        
        int k=length-1;
        if(k==-1)return "";
        
        int ei=0,si=0,index=k;
        
        long hash=0;
        
        while(ei<n){
             int val=s.charAt(ei++)-'a'+1;
            hash=(hash%mod+(val*powers[index--])%mod)%mod;
            
            if(ei-si==length){
                
                 if(map.containsKey(hash)){
                    String curr=s.substring(si,ei);
                   List<Integer> ind= map.get(hash);
                    for(int ele:ind){
                        
                        String ss=s.substring(ele,ele+length);
                        if(ss.equals(curr))return curr;
                    }
                    
                }else{
                    List<Integer> temp=new ArrayList<>();
                        
                        temp.add(si);
                        map.put(hash,temp);
                }
                
                
                int v=s.charAt(si)-'a'+1;
                hash=((hash)%mod-(v*powers[k])%mod+mod)%mod;
              
                hash=((hash)%mod*(power)%mod)%mod;
                si++;
                index=0;
            }
        }
           
        
        return "";
        
        
    }
    
    
}