class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans=new ArrayList<>();
            
         
          HashMap<String,List<String>> map=new HashMap<>();  
        int[] freq=new int[26];
          
           for(int i=0;i<strs.length;i++){
                 String str= strs[i];  
                   
                  for(char ch:str.toCharArray()){
                          
                          freq[ch-'a']=freq[ch-'a']+1;

                  } 
                  
                   String key="";
                          
                   for(int j=0;j<freq.length;j++){
                           // System.out.println(freq[j]);
                           key+=freq[j]+" ";
                           freq[j]=0;
                                                
                          
                   }
                                              // System.out.println(key);

                   
                   if(map.containsKey(key)){
                           map.get(key).add(str);
                   }else{
                           List<String> n=new ArrayList<>();
                           n.add(str);
                           map.put(key,n);
                   }
                   
                   
           } 
            
               for (Map.Entry mapElement : map.entrySet()) {
           
  
         
            List<String> value = ((List<String>)mapElement.getValue());
  
            ans.add(value);
        }
            return ans;
    }
}