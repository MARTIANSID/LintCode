class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<String> set=new HashSet<>();
        
        
        
        int ei=0,si=0,n=s.length();
        
        while(ei<n){
            ei++;
            
            if(ei-si==k){
               String res= s.substring(si,ei);
                set.add(res);
                si++;
            }

        }
        
        return set.size()==Math.pow(2,k);
    }
}