class Solution {
    public List<Integer> partitionLabels(String s) {
     
          HashMap<Character,Integer> map=new HashMap<>();
         int n=s.length(),index=-1;
            
         for(int i=0;i<n;i++){
                        map.put(s.charAt(i),i);
         }
            
            
            int max=map.get(s.charAt(0));
            List<Integer> ans=new ArrayList<>();
            for(int i=0;i<s.length();i++){
                    while(i<n&&max!=i){
                            max=Math.max(max,map.get(s.charAt(i)));
                                i++;
                            
                    }
                    
                   if(ans.size()==0){
                           ans.add(max+1);
                           index=max;
                           if(i<n-1)
                           max=map.get(s.charAt(i+1));
                                
                   }else{
                                
                           ans.add(max-index);
                           index=max;
                           if(i<n-1)
                           max=map.get(s.charAt(i+1));
                         
                           
                   }
                    
            }
            return ans;
            
    }
}