class Solution {
    public String minWindow(String s, String t) {
        
          
         int[] freq=new int[256];
        int si=0,ei=0,gsi=0,len=(int)1e9,n=s.length();
        int count=0;
        int gei=0;
            
            
            if(s.length()<t.length()){
                    return "";
            }
        
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            if(freq[ch]==0){
                
                count++;
            }
                freq[ch]++;
        }
        
        while(ei<n){
            if(freq[s.charAt(ei++)]--==1){
                count--;
            }
            
            while(count==0){
                if(ei-si<len){
                    gsi=si;
                    len=ei-si;
                    gei=ei;
                }
                
                if(freq[s.charAt(si++)]++==0){
                    count++;
                }
            }
            
        }
       
        return s.substring(gsi,gei);    
            

    }
}