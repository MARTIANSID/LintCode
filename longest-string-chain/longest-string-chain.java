class Solution {
    public int longestStrChain(String[] words) {
        
            
       int ans=0;
            HashMap<String,Integer> map=new HashMap<>();
                  HashMap<String,Integer> hmap=new HashMap<>();

            
          Arrays.sort(words,(a,b)->{
                 return  b.length()-a.length();
          });
            
               
            for(int i=0;i<words.length;i++){
                    map.put(words[i],1);
                    
            }
            
            // int[] dp=new int[words.length+1];
            
            for(int i=0;i<words.length;i++){
                    
                  ans=Math.max(solve(words[i],map,hmap)+1,ans);
                    
            }
            
            return ans;
            
    }
        
        public int solve(String word,HashMap<String,Integer> map,HashMap<String,Integer> hmap){
                
                

                
               int a=0;
                
              
                if(hmap.containsKey(word))return hmap.get(word);
            
                for(int i=0;i<word.length();i++){
                        
                    String rem=   word.substring(0, i) + word.substring(i + 1);
                        
                        if(map.containsKey(rem)){
                                a=Math.max(solve(rem,map,hmap)+1,a);
                        }
                        
                }
                
                
                hmap.put(word,a);
                
                
                return a;
        }
}