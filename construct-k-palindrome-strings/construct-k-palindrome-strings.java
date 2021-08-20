class Solution {
    public boolean canConstruct(String s, int k) {
        if(s.length()==k)return true;
        if(k>s.length())return false;
        HashMap<Character,Integer> map=new HashMap<>();
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
      
        int oddCount=0,evenCount=0;
        
         
        for (Map.Entry mapElement : map.entrySet()) {
            Integer key = (Integer)mapElement.getValue();
            if(key%2==0)evenCount++;
            else oddCount++;
        }
         
         if(oddCount>k)return false;
        
        
        
        return true;
        
        
        

    }
}