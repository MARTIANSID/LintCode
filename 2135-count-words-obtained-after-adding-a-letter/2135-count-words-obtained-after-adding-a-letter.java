class Solution {
    

    
    public int wordCount(String[] startWords, String[] targetWords) {
        int ans=0;
       
        
        
        HashMap<String,Integer> map=new HashMap<>();
        
        
        
            for(String s:startWords){
                
        char[] chars = s.toCharArray();  
        Arrays.sort(chars);
        String sorted = new String(chars);
            
             map.put(sorted,map.getOrDefault(sorted,0)+1);
        
    } 
        
        
        
        for(String t:targetWords){
           
            for(int i=0;i<t.length();i++){
                String str = t.substring(0, i) + t.substring(i+1);
                char[] chars = str.toCharArray();  
                Arrays.sort(chars);
                String sorted = new String(chars);
                if(map.containsKey(sorted)){
                    ans++;
                    break;
                }
            }

             
        }
        return ans;
    }
}


