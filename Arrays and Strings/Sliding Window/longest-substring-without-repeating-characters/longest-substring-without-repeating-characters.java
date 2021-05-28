class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
            
     
            
            
     int si=0;
        int ei=0;
            int max=0;
            
              int count=0;
        int[] freq=new int[256];
            
            
          
            while(ei<s.length()){
                    
                 char ch=s.charAt(ei);

                   freq[ch]++;
                   int x=freq[ch];
                       ei++;
                                                

                    if(x>1){
                            count=1;
                             
                            while(count!=0){
                              char c=   s.charAt(si);  
                                   
                                   if(freq[c]>1){
                                           
                                           count--;
                                           
                                   }
                                     freq[c]--;
                                    si++;
                                    
                                    
                            }
                             // max=Math.max(max,ei-si);
                    }else{
                            max=Math.max(max,ei-si);
                           
                     

                    }
                    
                
                    
            }
           
            return max;
            
            
    }
}