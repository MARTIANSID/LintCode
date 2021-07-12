class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        
        
        int[] freq=new int[26];
        int ans=-(int)1e9;
        
        HashMap<String,Integer> map=new HashMap<>();
        int uniq=0;
        int ei=0,si=0;
        while(ei<s.length()){
          freq[s.charAt(ei)-'a']++;
            
            if(freq[s.charAt(ei)-'a']==1){
                uniq++;
            }
            
           
            
            
            ei++;
            
            while(uniq>maxLetters){
             int u=  freq[s.charAt(si)-'a']-1;
             if(u==0){
                    uniq-- ;
                }
                
                freq[s.charAt(si)-'a']--;
                si++;
                
            
            }
            
            
            
            
            while(ei-si>=minSize&&uniq<=maxLetters){
                
                String str="";
                if(ei-si<=maxSize)
                 str=s.substring(si,ei);
                // System.out.println(str);
                if(!str.equals(""))
                if(map.containsKey(str)){
                    int f=map.get(str);
                    f++;
                    map.put(str,f);
                    ans=Math.max(ans,f);
                }else{
                    map.put(str,1);
                    ans=Math.max(ans,1);
                }
                
                   int u=  freq[s.charAt(si)-'a']-1;
               if(u==0){
                    uniq-- ;
                }
                
                freq[s.charAt(si)-'a']--;
                si++;
                
                
            }
            
            
            
                
                
            
            
            
            
        }
        
        return ans==-(int)1e9?0:ans;
        
    }
}


// "aababcaab"
    
    
    