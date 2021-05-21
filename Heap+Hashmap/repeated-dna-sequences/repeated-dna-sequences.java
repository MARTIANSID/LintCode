class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        
        List<String> ans=new ArrayList<>();
            
         HashMap<String,Integer> map=new HashMap<>();
            
            for(int i=0;i<s.length()&&i+9<s.length();i++){
                  String sub = s.substring(i,i+10);
                    if(map.containsKey(sub)){
                        if(map.get(sub)==1){
                                    ans.add(sub);
                            map.put(sub,2);
                        }
                    }
                    
                    else map.put(sub,1);
            }
            return ans;
    }
}